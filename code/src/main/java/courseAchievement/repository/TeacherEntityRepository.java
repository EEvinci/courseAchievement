package courseAchievement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.TeacherEntity;

public interface TeacherEntityRepository extends JpaRepository<TeacherEntity, Integer> {
    // 根据教师编号查询
    List<TeacherEntity> findByTeacherNumStringLike(String teacherNumString);

    // 根据教师姓名查询
    TeacherEntity findByTeacherNameStringLike(String teacherNameString);

    // 根据教师电话查询
    TeacherEntity findByTeacherPhoneStringLike(String teacherPhoneSting);

    // 根据教师编号删除
    void deleteById(String teacherNum);
}
