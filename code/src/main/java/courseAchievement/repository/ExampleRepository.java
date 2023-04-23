package courseAchievement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.Example;

/**
 * @author evinci
 * @version 1.0
 */

public interface ExampleRepository extends JpaRepository<Example, Integer> {
    List<Example> findByExampleNumString(String exampleNum);

    List<Example> findByExampleNumStringLike(String exampleNum);

    List<Example> findByExampleContentStringLike(String exampleContent);

    void deleteById(String exampleNum);
}
