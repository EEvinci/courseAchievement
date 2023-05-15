# TO-DO

## 代码层面

- [ ] controller中的repository转化为service, 要注意RESTful中的URI命名, 一定要是名词, 需要斟酌
- [ ] formbean添加lombok注解
- [ ] redis配置, 连接, 测试数据存储 - **impl中的cacheRedisService.java文件** - pom.xml文件中redis的配置
- [ ] service中对方法的变量是formbean还是entity的考量, 以读操作和写操作为判断基准
- [ ] impl接口完善, 在将entity转化为formbean时使用Builder注解的流式方法

## 设计方面

- [ ] 数据库表的优化, 需要考虑到系统的用户, 需要添加表以及定义相关的属性
- [ ] exampleLikeHistory和KnowledgeReadHistory的设计-redis, 这是什么玩意, 怎么实现的
- [ ] 系统标签 / 用户标签
- [ ] **标签的推荐功能** 依据标签的访问数量然后进行排名，挑前五个进行展示进行推荐
- [ ] 标签的访问记录 知识点访问记录 案例阅读记录 案例点赞记录