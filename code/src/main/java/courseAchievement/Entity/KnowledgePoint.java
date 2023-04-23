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
@Table(name = "knowledge_point", schema = "courseachievement", catalog = "")
public class KnowledgePoint {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "knowledge_point_num")
  private String knowledgePointNumString;

  @Column(name = "knowledge_point_description")
  private String knowledgePointDescriptionString;

  @Column(name = "knowledge_point_vital")
  private String knowledgePointVitalString;

  // @TODO: consider the relationship between knowledge point and label

  @Column(name = "pre_knowledge_point_id")
  private int PreKnowledgePointId;

  // 多对多关系 课程与知识点
  @ManyToMany(mappedBy = "knowledges")
  private Set<Course> courses = new HashSet<Course>();

  // 多对多关系 知识点与案例
  @ManyToMany
  @JoinTable(name = "knowledge_example", joinColumns = @JoinColumn(name = "knowledge_point_id"), inverseJoinColumns = @JoinColumn(name = "example_id"))
  @Builder.Default
  private Set<Example> examples = new HashSet<Example>();

  // 多对多关系 知识点与标签
  @ManyToMany
  @JoinTable(name = "knowledge_label", joinColumns = @JoinColumn(name = "knowledge_point_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
  @Builder.Default
  private Set<Label> labels = new HashSet<Label>();
}
