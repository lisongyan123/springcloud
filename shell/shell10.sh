#!/usr/bin/env bash
docker pull daocloud.io/nginx
# 创建nginx主服务容器，将容器的80端口映射到宿主主机的80端口
docker run --name nginx -it -p 80:80 -d -v /d/nginx.html:/var/www/nginx.html -v /d/nginx.conf:/etc/nginx/conf.d/default.conf daocloud.io/nginx

docker cp   d:/nginx/nginx.html 281dc4a77087d1cccb14b067451d9b350bd6b7fb558393505a500553e90fd629:/var/www/nginx.html

docker cp   d:/nginx/default.conf 281dc4a77087d1cccb14b067451d9b350bd6b7fb558393505a500553e90fd629:/etc/nginx/conf.d/default.conf

mkdir -p /nginx/www /nginx/logs /nginx/conf

docker cp d220be597544:/etc/nginx/nginx.conf d:/nginx/conf

docker run -d -p 8082:80 --name nginx-test-web -v d:/nginx/www:/usr/share/nginx/html -v d:/nginx/conf/nginx.conf:/etc/nginx/nginx.conf -v d:/nginx/logs:/var/log/nginx daocloud.io/nginx