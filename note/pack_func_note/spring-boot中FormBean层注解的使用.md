# FormBean中注解的使用

## 可以使用Lombok注解但不可以使用JPA或Hibernate注解

FormBean就是一个普通的Java类，在其中可以使用Lombok库的注解来简化代码

比如最常见的@Data，@NoArgsConstructor，@AllArgsConstructor, @Builder

但是像Entity中用的@Entity，@Column等与数据库建立关联的JPA或Hibernate注解在FormBean中无法使用，因为FormBean不直接与数据库进行交互

## 还可以使用的字段验证注解JSR 380

例如:

```java
public class CourseForm {
    @NotNull
    @Size(min = 2, max = 30)
    private String courseName;
    // 其他字段...
}
```

在上面的代码中，`@NotNull`注解表示`courseName`字段不能为空，`@Size(min = 2, max = 30)`注解表示`courseName`字段的长度必须在2到30之间。如果这些条件不满足，当你尝试将用户提交的数据绑定到`CourseForm`对象时，Spring MVC会自动产生一个错误，并将错误信息添加到BindingResult对象中，可以检查这个对象来处理错误。