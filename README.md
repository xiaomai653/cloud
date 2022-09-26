
## Spring CloudA libaba 项目

### 介绍
cloud是一套微服务系统的

### 项目结构
```
cloud
├─admin                 --  监控中心
├─auth                  --  auth
│  ├─oauth2-server      --  oauth2认证授权
│  ├─sso-client-one     --  单点登录客户端1
│  ├─sso-client-two     --  单点登录客户端2
│  └─sso-server         --  单点登录服务端
├─config                --  配置中心
├─consumer              --  服务消费者
├─gateway               --  gateway网关
├─provider              --  服务提供者
└─sentinel              --  sentinel流量控制
```