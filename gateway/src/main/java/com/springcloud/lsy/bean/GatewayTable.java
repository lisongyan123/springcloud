package com.springcloud.lsy.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

/**
 * GATEWAY_TABLE
 * @author 
 */
@Data
public class GatewayTable implements Serializable {
    private String id;

    private String predicate;

    private String filter;

    private String uri;

    private Integer order;

    private Date create_time;

    private Date update_time;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public List<PredicateDefinition> getPredicateDefinition() {
        if (this.predicate != null) {
            List<PredicateDefinition> predicateDefinitionList = JSON.parseArray(this.predicate, PredicateDefinition.class);
            return predicateDefinitionList;
        } else {
            return null;
        }
    }

    public List<FilterDefinition> getFilterDefinition() {
        if (this.filter != null) {
            List<FilterDefinition> filterDefinitionList = JSON.parseArray(this.filter, FilterDefinition.class);
            return filterDefinitionList;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "GatewayDefine{" +
                "id='" + id + '\'' +
                ", uri='" + uri + '\'' +
                ", predicates='" + predicate + '\'' +
                ", filters='" + filter + '\'' +
                '}';
    }
}