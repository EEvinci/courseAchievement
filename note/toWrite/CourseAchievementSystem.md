# CourseAchievementSystem

[TOC]

## 层间结构图

基于Spring Boot的典型项目的层间结构图示例：

```cmd
                +--------------+
​                |  Controller  |
​                +--------------+
​                       |
​                +--------------+
​                |  Service     |
​                +--------------+
​                       |
​                +--------------+
​                |  Repository  |
​                +--------------+
​                       |
​                +--------------+
​                |  Database    |
​                +--------------+
```


其中，各层的作用如下：

- Controller：接收请求，处理参数，并调用相应的Service进行业务处理，然后将结果返回给客户端。

- Service：处理业务逻辑，调用Repository访问数据库，返回结果给Controller。
- Repository：访问数据库，执行相应的CRUD操作。
- Database：持久化数据的存储层。

## 管理界面功能实现思路

### 以课程管理界面为例

基于 Spring Boot 实现`(课程)`管理界面的功能，可以遵循以下步骤：

- 首先需要定义一个`(课程)`实体类，包括`(课程编号、课程名称、教师、上课时间、地点等)`属性，可以**使用 @Entity 注解将其映射为数据库表**，并使用 @Id、@GeneratedValue 等注解定义主键和自增策略。
- 在 DAO 层中定义一个课程的**数据访问接口**，该接口需要**继承 JpaRepository 或 CrudRepository 接口**，并实现一些**自定义的方法**，例如按照`(课程名称)`进行模糊查询等。
- 在 **Service 层中定义一个`(课程)`的服务接口**，并实现一些**业务逻辑方法**，例如**`(新增课程、编辑课程、删除课程)`**等，这些方法需要**调用 DAO 层提供的方法**来实现**具体的数据访问逻辑**。
- 在 **Controller 层**中定义一个**`(课程管理)`的 RESTful API 接口**，通过 **@RequestMapping、@GetMapping、@PostMapping** 等注解来**定义接口的 URL 和 HTTP 方法**，并**在方法中调用 Service 层提供的业务逻辑方法**，最终**将处理结果返回给前端**。

除了以上步骤，还需要在应用程序的**配置文件 application.properties** 中配置数据库连接信息、日志级别、服务器端口等参数。

# 实体定义

## 课程 course

### 属性

- 课程号id
- 课程名称name
- 课程简介intro
- 教材book
- 标签（多个）lable
- 负责老师teacher

### 功能

- 新增课程
- 删除课程
- 查询课程
- 修改课程
- 更新课程信息
- 设置课程标签

## 知识点 knowledge

### 属性

- 知识点名称name、
- 知识点描述desc、
- 重点说明highlight、
- **案例（多个，富文本，含代码）case、**
- **前置知识点（列表）preknow、**
- **标签（多个）lable**

### 功能

- 新增知识点
- 删除知识点
- 查询知识点
- 修改知识点

## 课程标签 lable

### 属性

- 标签 id
- 标签名称 lableName
- 标签组 lableGroupId

### 功能

- 新增标签
- 删除标签
- 查询标签
- 修改标签

## 课程标签组 lableGroup

### 属性

- 标签组 lableGroupId
- 标签组名称 lableGroupName

### 功能

- 新增标签组
- 删除标签组
- 查询标签组
- 修改标签组



## 类图

![image-20230319212850943](http://evinci.oss-cn-hangzhou.aliyuncs.com/evinci/image-20230319212850943.png)