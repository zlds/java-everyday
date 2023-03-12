# nacos配置项
```
spring:
  cloud:
    gateway:
      routes:
        - id: http-proxy
          uri: https://www.iocoder.cn # 路由到目标地址
          predicates:
            - Path=/blog
          filters:
            - StripPrefix=1 # 去掉前缀
        - id: oschina-proxy
          uri: https://www.oschina.net
          predicates:
            - Path=/oschina
          filters:
            - StripPrefix=1
        - id: baidu-proxy
          uri: https://www.baidu.com
          predicates:
            - Path=/baidu
          filters:
            - StripPrefix=1    
```