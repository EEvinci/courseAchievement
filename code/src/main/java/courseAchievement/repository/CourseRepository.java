package courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.Course;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByCourseNumStringLike(String courseNumString);

    List<Course> findByCourseNameStringLike(String courseNameString);

    void deleteById(String courseNum);
}
