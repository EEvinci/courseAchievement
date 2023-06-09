# Lombok库的使用

[TOC]

## Lombok的作用

Lombok库的注解，用于**简化Java类的编写**

Lombok可以**自动生成**一些**通用的方法和构造函数**，减少了手动编写这些代码的工作量

## 适用场景

Lombok通常用于**简化数据对象**（如**JavaBean、POJO、DTO**等）或**实体类（Entity）**的编写。

这些类**通常包含许多成员变量**，以及**相应的getter、setter和构造函数**。通过使用Lombok，可以减少手动编写这些通用方法和构造函数的工作量，提高代码的可读性和可维护性。

Lombok适用于以下场景：

1. **数据对象**：如**JavaBean、POJO、DTO**等，它们**主要包含数据和一些基本操作，没有复杂的业务逻辑**。
2. **实体类**：如**数据库实体映射类（Entity）**，用于表示**数据库表的数据结构**。
3. **配置类**：用于**表示配置信息的类**，通常包含一些**配置属性和默认值**。
4. **简单的业务对象**：用于处理一些**简单业务逻辑的类**，它们通常包含一些**成员变量和简单方法**。

需要注意的是，Lombok并不适用于所有场景。在一些具有**复杂业务逻辑**的类中，可能需要**手动编写方法和构造函数**，以实现**特定功能和约束**。

## 常用注解

- @Getter：为类的成员变量生成getter方法。
- @Setter：为类的成员变量生成setter方法。
- @ToString：为类生成toString方法，用于将类的实例转换为字符串表示。
- @EqualsAndHashCode：为类生成equals和hashCode方法，用于比较两个对象是否相等。
- <u>**@Data**：**相当于@Getter、@Setter、@ToString、@EqualsAndHashCode的组合，同时生成getter、setter、toString、equals和hashCode方法。**</u>



- **@NoArgsConstructor**：**为类生成一个无参构造函数。**
- **@AllArgsConstructor**：**为类生成一个全参构造函数，即包含所有成员变量的构造函数。**



- **@RequiredArgsConstructor**：为类生成一个**带有必需参数的构造函数**，这些参数是**由final修饰**或者**标记了@NonNull**的成员变量。
- **@Builder**：为类生成一个**Builder模式的API**，用于**创建不可变对象和复杂对象**。



- @SneakyThrows：允许在方法中抛出检查型异常，而无需在方法签名中声明。
- **@Slf4j：为类生成一个SLF4J（Simple Logging Facade for Java）日志实例。**
- **@Cleanup：自动为资源（如文件、流等）添加try-with-resources语句，确保资源被正确关闭。**



// TODO 不可变类是什么？将所有的属性都应用于final字段会带来什么影响？

- **@Value**：相当于**将@Data、@AllArgsConstructor、@NoArgsConstructor等**注解**应用于不可变类**（即**类的所有字段都是final的**）。

## 使用方式

### 引入依赖

要在代码中使用Lombok，需要在项目的pom.xml文件中引入Lombok依赖

```xml
<dependencies>
    <!-- Other dependencies -->

    <!-- Lombok dependency -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.20</version>  <!--version needs to be changed -->
        <scope>provided</scope>
    </dependency>

</dependencies>
```

### 在代码文件头部引入库函数

方式：

`import lombom.注解名`

例如：

```java
import lombok.Data;
import lombok.Builder;
...
```



## 参考文档

[Springboot使用JPA框架对数据库实现增删改查（附详细代码）](https://blog.csdn.net/qq_30237715/article/details/116702134)

[使用注解](https://www.liaoxuefeng.com/wiki/1252599548343744/1265102413966176)

[Spring Data JPA 默认和自定义命名约定](https://blog.csdn.net/allway2/article/details/127267569)
