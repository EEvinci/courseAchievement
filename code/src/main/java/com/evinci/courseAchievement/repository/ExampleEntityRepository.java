package courseAchievement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.ExampleEntity;

/**
 * @author evinci
 * @version 1.0
 */

public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Integer> {
    // 根据案例编号查询
    List<ExampleEntity> findByExampleNumString(String exampleNum);

    // 根据案例内容查询
    List<ExampleEntity> findByExampleNumStringLike(String exampleNum);

    // 根据案例编号删除
    List<ExampleEntity> findByExampleContentStringLike(String exampleContent);

    // 根据案例编号删除
    void deleteById(String exampleNum);
}
