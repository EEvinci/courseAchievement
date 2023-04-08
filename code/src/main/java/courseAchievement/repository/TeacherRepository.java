package courseAchievement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByTeacherNumStringLike(String teacherNumString);

    Teacher findByTeacherNameStringLike(String teacherNameString);

    Teacher findByTeacherPhoneStringLike(String teacherPhoneSting);

    void deleteById(String teacherNum);
}
