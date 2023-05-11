package courseAchievement.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "knowledge", schema = "courseachievement", catalog = "")
public class KnowledgeEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "knowledge_num")
  private String knowledgeNum;

  @Column(name = "knowledge_description")
  private String knowledgeDescription;

  @Column(name = "knowledge_vital")
  private String knowledgeVital;

  // @TODO: consider the relationship between knowledge  and label

  @Column(name = "preknowledge_id")
  private int PreknowledgeId;

  // 多对多关系 课程与知识点
  @ManyToMany(mappedBy = "knowledges")
  private Set<CourseEntity> courses = new HashSet<CourseEntity>();

  // 多对多关系 知识点与案例
  @ManyToMany
  @JoinTable(name = "knowledge_example", joinColumns = @JoinColumn(name = "knowledge_id"), inverseJoinColumns = @JoinColumn(name = "example_id"))
  @Builder.Default
  private Set<ExampleEntity> examples = new HashSet<ExampleEntity>();

  // 多对多关系 知识点与标签
  @ManyToMany
  @JoinTable(name = "knowledge_label", joinColumns = @JoinColumn(name = "knowledge_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
  @Builder.Default
  private Set<LabelEntity> labels = new HashSet<LabelEntity>();
}
