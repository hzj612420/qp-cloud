# springcloud的脚手架开发项目，基于restfulAPI

该项目目前只整合了 用户 权限认证、以及 日志管理等功能，因为只做为是个项目开发脚手架。

### 项目整合
* JDK1.8
* springboot2.1.6
* springcloud(Greenwich.SR2)
* spring-cloud-eureka
* spring-cloud-config
* spring-cloud-gateway
* spring-boot-admin(monitor)
* swagger&swagger-bootstrap-ui
* redis
* mysql
* lombok

### 项目目录结构
```
project-cloud
|
├──project-common --通用包
|  |
|  ├──project-common-core --核心工具包
|  |
|  ├──project-common-redis --redis工具包
|  |
|  ├──project-common-log --日志工具包
|  |
|  ├──project-common-auth --权限工具包
|
├──project-config --cloud统一配置中心
|
├──project-eureka --注册中心
|
├──project-gateway --网关
|
├──project-service-api --服务api模块
|  |
|  ├──project-system-api --系统业务api
|
├──project-service --微服务
|  |
|  ├──project-system --系统业务
|  |
|  ├──project-auth --授权中心
|  |
|  ├──project-gen --代码生成
|  |
|  ├──project-dfs --文件
|
├──project-tool --工具
|  |
|  ├──project-monitor --监控中心

```
idea插件
    小辣椒Lombok(去除java臃肿) 
    阿里巴巴代码规范检查插件alibaba java code guidelines(具体规范再doc下) 
    安装好后重启idea 右键项目下面就可以看到编码规范检查 看看代码有多少是不规范的

启动前需要确认
* 本地开了redis 端口6379 
* mysql建立数据库，执行sql文件夹中的sql 端口3306 
* 账号密码看配置文件config/project-system-dev.yml

### 启动顺序
* EurekaApplication
* ConfigApplication
* GatewayApplication
* SystemApplication
* AuthApplication(可选)
* MonitorApplication(可选)
* PlayerApplication

接口文档地址：http://localhost:9572/doc.html

### 项目是参考 `ruoyi-cloud` 编写  
https://github.com/zhangmrit/ruoyi-cloud
QQ群755109875

全部启动之后打开postman
url 127.0.0.1:9572/auth/login
post
body-raw-json
输入
{
	"username":"admin",
	"password":"123456"
}
获得响应"token": "45a2911dd5b14426ab8837d942c83723"

接下来带着token请求其他接口
127.0.0.1:9572/system/logininfor/list
headers添加参数
token 45a2911dd5b14426ab8837d942c83723 请求即可，其他同理

