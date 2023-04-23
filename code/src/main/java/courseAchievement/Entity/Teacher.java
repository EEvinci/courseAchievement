package courseAchievement.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "teacher", schema = "courseachievement", catalog = "")
public class Teacher {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "teacher_num")
    private String teacherNumString;

    @Column(name = "teacher_name")
    private String teacherNameString;

    @Column(name = "teacher_phone")
    private String teacherPhoneString;

    @Column(name = "teacher_description")
    private String teacherDescriptionString;
}