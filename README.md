# CommentsApp

## 项目特色

### 共享session

+ 基于Redis实现共享session登录、鉴权

### 缓存问题

+ 基于Redis实现商家缓存主动更新
+ 基于缓存空对象解决缓存穿透
+ 基于互斥锁和逻辑过期解决缓存击穿

### 分布式锁

+ 基于乐观锁实现对超卖问题的处理
+ 基于悲观锁，并通过暴露AOP代理对象，以及降低锁粒度解决一人一单问题
+ 基于Redission实现分布式锁
+ 使用基于Stream的Redis消息队列和lua脚本优化秒杀业务

## 运行部署

### 前端

通过nginx部署，相关配置文件与静态资源在/src/main/resources/nginx目录下

### 后端

修改application.yaml,配置MySQL数据库和Redis数据库。其中MySQL数据库提供了初始化脚本，位于/src/main/resources/db目录下。
需要在Redis-cli中运行如下命令  `XGROUP CREATE stream.orders g1 0 MKSTREAM`

