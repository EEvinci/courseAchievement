package courseAchievement.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "label", schema = "courseachievement", catalog = "")
public class Label {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "label_num")
  private String labelNumString;

  @Column(name = "label_content")
  private String labelContentString;

  // 多对一关系（外键）
  @JoinColumn(name = "label_group_id")
  @Column(name = "label_group_id")
  private int labelGroupId;

  // 多对多关系 标签与课程
  @ManyToMany(mappedBy = "labels")
  private Set<Course> courses = new HashSet<Course>();

  // 多对多关系 标签与知识点
  @ManyToMany(mappedBy = "labels")
  @Builder.Default
  private Set<KnowledgePoint> knowledgePoint = new HashSet<>();

}
