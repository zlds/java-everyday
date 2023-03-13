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
            # - Path=/oschina
            - Path=/oschina
            # 设置权重分组
            - Weight=user-service, 90
          filters:
            - StripPrefix=1
        - id: baidu-proxy
          uri: https://www.baidu.com
          predicates:
            # - Path=/baidu
            - Path=/baidu
            - Weight=user-service, 10
          filters:
            - StripPrefix=1
        - id: user-service
          # 用户服务名称
          uri: lb://user-service
          predicates:
            - Path=/user/**
          filters:
            - StripPrefix=1
      default-filters:
        - name: Auth
          args:
            token-header-name: access-token         
```