package com.example.webflux.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONObject;
import com.example.webflux.es.GoodsIndex;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.PutIndexTemplateRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/elasticsearch")
public class HelloController {

    @Autowired
    RestHighLevelClient highLevelClient;

    private  ElasticsearchOperations elasticsearchOperations;


    public HelloController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @GetMapping("/template")
    public void putTemplate()throws IOException{
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("goods_template");
        //别名，所有根据该模版创建的index 都会添加这个别名。查询时可查询别名，就可以同时查询多个名称不同的index，根据此方法可实现index每天或每月生成等逻辑。
        request.alias(new Alias("goods_index"));
        request.order(10);
        //匹配哪些index。在创建index时会生效。
        request.patterns(CollUtil.newArrayList("goods_index*"));
        request.settings(Settings.builder()
                //数据插入后多久能查到，实时性要求高可以调低
                .put("index.refresh_interval", "1s")
                //传输日志，对数据安全性要求高的 设置 request，默认值:request
                .put("index.translog.durability", "async")
                .put("index.translog.sync_interval", "120s")
                //分片数量
                .put("index.number_of_shards", "5")
                //副本数量
                .put("index.number_of_replicas", "0")
                //单次最大查询数据的数量。默认10000。不要设置太高，如果有导出需求可以根据查询条件分批次查询。
                .put("index.max_result_window", "100000"));
        //使用官方提供的工具构建json。可以直接拼接一个json字符串，也可以使用map嵌套。
        XContentBuilder jsonMapping = XContentFactory.jsonBuilder();
        //所有数据类型 看官方文档:https://www.elastic.co/guide/en/elasticsearch/reference/7.4/mapping-types.html#_core_datatypes
        jsonMapping.startObject().startObject("properties")
                .startObject("goodsName").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .startObject("goodsId").field("type", "integer").endObject()
                //keyword类型不会分词存储
                .startObject("connet").field("type", "text").endObject()
                //指定分词器
                .endObject().endObject();
        request.mapping(jsonMapping);
        //设置为true只强制创建，而不是更新索引模板。如果它已经存在，它将失败
        request.create(false);
        AcknowledgedResponse response = highLevelClient.indices().putTemplate(request, RequestOptions.DEFAULT);
        if (response.isAcknowledged()) {
            Console.log("创建模版成功!");
        } else {
            Console.log("创建模版失败!");
        }
    }

    @DeleteMapping("")
    public void deleteIndex(Integer id) throws IOException {
//        DeleteIndexRequest request = new DeleteIndexRequest("goods_index*");
        DeleteRequest  request = new DeleteRequest("goods_index",id.toString());
        DeleteResponse delete = highLevelClient.delete(request,RequestOptions.DEFAULT);
//        AcknowledgedResponse response = highLevelClient.indices().delete(request, RequestOptions.DEFAULT);
    }

    @PostMapping("/create")
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("goods_index_tmp");
        CreateIndexResponse createIndexResponse = highLevelClient.indices().create(request, RequestOptions.DEFAULT);
        if (createIndexResponse.isAcknowledged()) {
            Console.log("创建index成功!");
        } else {
            Console.log("创建index失败!");
        }
    }

    @PostMapping("")
    public void insertIndex() throws IOException {
        BulkRequest request = new BulkRequest("goods_index_" + DateUtil.format(new Date(), "yyyyMM"));
        for (int i = 0; i < 5; i++) {
            GoodsIndex testData = new GoodsIndex();
            testData.setGoodsId(i);
            testData.setConnet(i+"号商品简介----------------");
            testData.setGoodsName("商品---------------"+i);
            IndexRequest indexRequest = new IndexRequest("goods_index_" + DateUtil.format(new Date(), "yyyyMM"));
            indexRequest.id(testData.getGoodsId().toString());
            indexRequest.source(new JSONObject(testData).toString()
                    , XContentType.JSON);
            request.add(indexRequest);
        }
        BulkResponse response = highLevelClient.bulk(request, RequestOptions.DEFAULT);
        Console.log("插入状态:{} 数量:{} ",response.status(),response.getItems().length);
    }

    @PutMapping("")
    public void update(Integer id) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("goods_index", id.toString());
        GoodsIndex goodsIndex=new GoodsIndex();
        goodsIndex.setGoodsId(id);
        goodsIndex.setGoodsName("未知商品");
        goodsIndex.setConnet("未知内容");
        updateRequest.doc(new JSONObject(goodsIndex).toString()
                , XContentType.JSON);
        highLevelClient.update(updateRequest, RequestOptions.DEFAULT);
    }

    @GetMapping("")
    public void query(String keyword,Integer id) throws IOException {
        SearchRequest searchRequest = new SearchRequest("goods_index");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("goodsName", keyword)
                .fuzziness(Fuzziness.AUTO)
                .analyzer("ik_max_word")
                .operator(Operator.AND)
                .prefixLength(3)
                .maxExpansions(10);

        boolQueryBuilder.must(QueryBuilders.termQuery("goodsId", id));
        boolQueryBuilder.must(matchQueryBuilder);

        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchSourceBuilder.sort(new FieldSortBuilder("goodsId").order(SortOrder.ASC));

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            Map<String, Object> map = hit.getSourceAsMap();
            System.out.println(hit);

        }
    }
}
