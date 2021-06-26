#!/usr/bin/env bash
#mkdir -p C:/Users/w/Desktop/mydata/elasticsearch/config # 在mydata文件夹下创建es的config文件夹，将docker中es的配置挂载在外部，当我们在linux虚拟机中修改es的配置文件时，就会同时修改docker中的es的配置
#mkdir -p C:/Users/w/Desktop/mydata/elasticsearch/data #在mydata文件夹下创建es的data文件夹
#echo "http.host:0.0.0.0" >> C:/Users/w/Desktop/mydata/elasticsearch/config/elasticsearch.yml # [http.host:0.0.0.0]允许任何远程机器访问es，并将其写入es的配置文件中

docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" \
-v C:/Users/w/Desktop/mydata/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
 -d elasticsearch:7.6.2

# docker run --name elasticsearch 创建一个es容器并起一个名字；
# -p 9200:9200 将linux的9200端口映射到docker容器的9200端口，用来给es发送http请求
# -p 9300:9300 9300是es在分布式集群状态下节点之间的通信端口  \ 换行符
# -e 指定一个参数，当前es以单节点模式运行
# *注意，ES_JAVA_OPTS非常重要，指定开发时es运行时的最小和最大内存占用为64M和128M，否则就会占用全部可用内存
# -v 挂载命令，将虚拟机中的路径和docker中的路径进行关联
# -d 后台启动服务
#docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -d elasticsearch:latest