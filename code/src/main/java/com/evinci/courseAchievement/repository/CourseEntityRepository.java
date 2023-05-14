package courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.CourseEntity;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface CourseEntityRepository extends JpaRepository<CourseEntity, Integer> {
    // 根据课程编号查询
    List<CourseEntity> findByCourseNumStringLike(String courseNumString);

    // 根据课程名称查询
    List<CourseEntity> findByCourseNameStringLike(String courseNameString);

    // 根据课程编号删除
    void deleteById(String courseNum);
}
