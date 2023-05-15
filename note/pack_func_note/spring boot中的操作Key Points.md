# Key Points

[TOC]

## Lombok库中注解的使用-主要体现在entity类中

比较常用的就是以下这四个注解

![image-20230514130328741](https://evinci.oss-cn-hangzhou.aliyuncs.com/img/image-20230514130328741.png)

## JPA数据库操作-entity类

![image-20230514132017713](C:\Users\PC\AppData\Roaming\Typora\typora-user-images\image-20230514132017713.png)

在entity中使用以上这些注解表示该类是一个实体类, 并从代码层面对实体的属性进行操作, 使得对数据库的操作更加方便灵活

比如使用@Entity表明这是一个实体类

使用@Table表明该实体的属性对应于数据库的哪一个表

使用@Id注解标定主键

使用@JoinColumn注解表示代码中的实体属性对应数据库中的哪列属性

使用@ManyToMany注解表示多对多关系

使用@GeneratedValue实现自增

使用@JoinTable可以创建关联表, 适合于两个有联系的表

还有@ManyToOne和@OneToMany表示一对多和多对一关系的注解

还有等等....

## 根据Entity代码改动在properties文件中自动更改数据库

```properties
# auto create table from entity when start 
spring.jpa.hibernate.ddl-auto=update
```

这样每次启动项目, 数据库中的表和属性都会以项目中的entity包中的属性定义为基准, 与之做相应的更新

如果要对数据库进行更改就不用先改数据库再改代码了, 直接修改代码然后数据库随之更新即可, 更加灵活简便

### 那么有几个问题: 

#### 当数据库中有数据时, 这时直接在代码中将一个有数据的属性删除了, 那么在启动项目的时候数据库中会有什么变化?

> **这取决于具体的JPA供应商和配置**。对于**Hibernate（Spring Boot默认的JPA供应商）**，在`spring.jpa.hibernate.ddl-auto`设置为**`update`模式**下，Hibernate会**尝试将数据库模式（即表结构）与Entity类保持一致**。但是，**Hibernate不会删除任何已经存在的列**。
>
> 所以，如果你在Entity类中删除一个属性，对应的数据库列仍然会保留，只是Hibernate不再管理它。
>
> 
>
> > 那如果表属性发生变动, 表中没有数据, 那么之前的旧属性会不会被删除?
> >
> > 这里说的不会被删除只是在该属性列中有数据的情况下才不会被删除是吧?
>
> > 如果你在Entity类中删除了一个属性，**即使表中没有对应列的数据，那个列仍然会在数据库中保留**。Hibernate的**`update`策略并不会删除任何已经存在的列，无论那个列是否有数据**。
> >
> > 这是因为在大多数情况下，**删除一个已经存在的列可能会导致数据丢失**，这是一个相对危险的操作，Hibernate选择了避免这样的操作。
> >
> > 这就是为什么在**生产环境**中，**数据库模式的更改通常不是由Hibernate自动完成**，而是通过**数据库迁移工具**（如Flyway或Liquibase）以**更可控的方式**进行。这些工具可以让你明确地指定每一步的模式更改，包括添加、修改和删除列，并且可以包含对应的数据迁移步骤。



#### 当数据库中有数据时, 再启动项目会不会将数据清除?

> 对于`spring.jpa.hibernate.ddl-auto=update`，Hibernate将**尝试对数据库进行更新以匹配Entity类**，但**它不会删除任何数据**。如果你添加或修改了Entity类中的属性，Hibernate可能会添加新的列或修改现有的列的类型，**但已经存在的数据不会被清除。**
>
> 另一方面，如果你将`spring.jpa.hibernate.ddl-auto`设置为**`create`或`create-drop`**，那么每次应用程序启动时，**Hibernate都会删除所有的表和数据，然后重新创建它们。**

well

> 注意：使用`spring.jpa.hibernate.ddl-auto=update`在**开发阶段**可能非常方便，因为你**不需要手动更新数据库模式。**
>
> **但是在生产环境中，自动更新通常是不被推荐的**，因为它**可能会导致数据丢失或其他不可预见的问题**。
>
> 在生产环境中，数据库模式的更改通常通过**数据库迁移工具（如Flyway或Liquibase）**以**更可控的方式**进行。

## service层中的formbean使用

- 对于读操作，我们会直接从数据库获取 Entity 对象，然后将其转换为 FormBean 或者 DTO（Data Transfer Object）对象，再返回给前端。这样做的好处是，可以避免将数据库中的敏感信息或者不必要的信息暴露给前端。
- 对于写操作，我们通常会接收前端传来的 FormBean 或者 DTO 对象，然后在服务层将其转换为 Entity 对象，再进行数据库操作。这样做的好处是，可以避免前端直接操作数据库的实体对象，保证了数据的安全性和一致性。