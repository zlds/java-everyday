# 认证流程
流程如下:
1、授权服务器给客户端颁发id和秘钥
2、客户端使用id向授权服务器申请授权码
3、授权服务器校验id和秘钥，颁发授权码
4、客户端使用授权码向资源服务器申请资源
5、资源服务器验证授权码
6、验证通过生成token返回给客户端

演示地址:
http://localhost:10010/oauth/authorize?response_type=code&client_id=user-service&redirect_uri=https://www.baidu.com

# 获取token
http://localhost:10010/oauth/token?client_id=user-service&client_secret=xyz&grant_type=password&username=admin&password=123456

# 验证token是否过期
http://localhost:10010/oauth/check_token?token=xxx

# 刷新token
http://localhost:10010/oauth/token?client_id=user-service&client_secret=xyz&grant_type=refresh_token&refresh_token=xxx