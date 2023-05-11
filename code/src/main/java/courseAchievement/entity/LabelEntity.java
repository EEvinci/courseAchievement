package courseAchievement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

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
public class LabelEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "label_num")
  private String labelNum;

  @Column(name = "label_content")
  private String labelContent;

  // 多对一关系（外键）
  @JoinColumn(name = "label_group_id")
  @Column(name = "label_group_id")
  private int labelGroupId;

  // 多对多关系 标签与课程
  @ManyToMany(mappedBy = "labels") // mappedBy表示由CourseEntity中的labels字段维护关系
  private Set<CourseEntity> courses = new HashSet<CourseEntity>();

  // 多对多关系 标签与知识点
  @ManyToMany(mappedBy = "labels")
  @Builder.Default
  private Set<KnowledgeEntity> knowledgePoint = new HashSet<>();

}
