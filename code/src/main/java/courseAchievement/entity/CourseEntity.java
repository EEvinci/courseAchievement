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
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course", schema = "courseachievement", catalog = "")
public class CourseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "course_num")
  private String courseNumString;

  @Column(name = "course_name")
  private String courseNameString;

  @Column(name = "course_description")
  private String courseDescriptionString;

  @Column(name = "course_credit")
  private String courseCreditString;

  @Column(name = "course_book")
  private String courseBookString;

  @Column(name = "course_teacher_id")
  private int courseTeacherId;

  // 多对多关系 课程与标签
  @ManyToMany
  @JoinTable(name = "course_label", joinColumns = @JoinColumn(name = "label_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
  @Builder.Default
  private Set<LabelEntity> labels = new HashSet<>();

  // 多对多关系 课程与知识点
  @ManyToMany
  @JoinTable(name = "course_knowledge", joinColumns = @JoinColumn(name = "knowledge_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
  @Builder.Default
  private Set<KnowledgeEntity> knowledges = new HashSet<>();
}
