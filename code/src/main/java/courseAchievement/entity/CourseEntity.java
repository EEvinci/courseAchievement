package courseAchievement.entity;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author evinci
 * @version 1.0
 */
@Entity  // 类注解，表示该类是一个实体类
@Data  // 类注解，提供类的get、set、equals、hashCode、canEqual、toString方法
@Builder  // 类注解，提供类的builder方法，可以使用流式的调用方法
@NoArgsConstructor  // 类注解，提供类的无参构造方法
// @Builder和@NoArgsConstuctor注解会有冲突，因为
@AllArgsConstructor   // 类注解，提供类的全参构造方法
@Table(name = "course", schema = "courseachievement", catalog = "")  // 类注解，表示该类对应的表名是 course，schema表示数据库名，catalog一般来说为空
public class CourseEntity {
  @Id  // 表示该字段是主键
  @Column(name = "id")  // 表示该字段对应的数据库中的字段名
  @GeneratedValue(strategy = GenerationType.IDENTITY)  // 表示该字段是自增的
  private int id; 

  @Column(name = "course_num")
  private String courseNum;  

  @Column(name = "course_name")
  private String courseName;  

  @Column(name = "course_description")
  private String courseDescription;

  @Column(name = "course_credit")
  private String courseCredit;

  @Column(name = "course_book")
  private String courseBook;

  @Column(name = "course_teacher_id")
  private int courseTeacherId;

  // 多对多关系 课程与标签
  @ManyToMany
  // @JoinTable表示该字段是一个多对多关系，name表示中间表的表名，joinColumns表示中间表中的外键字段，inverseJoinColumns表示中间表中的另一个外键字段
  // 创建一个连接表，连接表中有两个字段，一个是label_id，一个是course_id，分别对应LabelEntity和CourseEntity的主键
  @JoinTable(name = "course_label", joinColumns = @JoinColumn(name = "label_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
  // 为集合字段提供默认值，避免遭遇空指针异常
  
  @Builder.Default 
  private Set<LabelEntity> labels = new HashSet<>();  // 集合字段，表示该课程对应的标签集合

  // 多对多关系 课程与知识点
  @ManyToMany
  @JoinTable(name = "course_knowledge", joinColumns = @JoinColumn(name = "knowledge_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
  @Builder.Default  
  private Set<KnowledgeEntity> knowledges = new HashSet<>();
}
