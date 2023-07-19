# CommentsApp

## 项目特色

### 共享session

+ 基于Redis实现共享session登录

### 缓存问题

+ 基于Redis实现商家缓存主动更新
+ 基于缓存空对象解决缓存穿透
+ 基于互斥锁和逻辑过期解决缓存击穿

### 秒杀问题

+ 基于乐观锁实现对超卖问题的处理

## 运行部署

### 前端

通过nginx部署，相关配置文件与静态资源在/src/main/resources/nginx目录下

### 后端

修改application.yaml,配置MySQL数据库和Redis数据库。其中MySQL数据库提供了初始化脚本，位于/src/main/resources/db目录下。

