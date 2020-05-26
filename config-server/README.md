# config-serve学习案例

## 启动类
```java
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
```

## 配置写在bootstrap.yml里面，因为加载的过程中，他优先于application，涉及到一些加密的，就可以提前
```yml
spring:
  application:
    name: config-server
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/lsy?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true
    username: root
    password: 123456
#  profiles:
#    active: native #设置使用本地配置(默认是git,可以设置：subversion(SVN)，native(本地))
#  cloud:
#    config:
#      name: config-server
#      server:
#        #如下是本地文件配置
#        native:
#          #文件前缀一定要加file:否则propertySources会报空,而且读取的文件命名一定以{spring.application.name}-{profile}.propertie或.yml
#          #访问的时候直接http://localhost:7001/config-server/dev这样的格式,跟上面的对应关系
#          search-locations: file:D:\conf
#          add-label-locations: true
  cloud:
    config:
      server:
        git:
          uri: https://github.com/lisongyan123/config.git
          search-paths: config
          username: username #账号密码写真实的快一些我觉得，不使用也能访问有点慢
          password: password
  #解决github上的编码问题
  http:
    encoding:
      charset: UTF-8
      enabled: true
      force: true
management:
  endpoint:
    health:
      show-details: always
  security:
    enabled: false
  endpoints:
    web:
      exposure:
        include: "*"
    refresh:
      enabled: true
'''