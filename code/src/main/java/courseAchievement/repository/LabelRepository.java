package courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.Entity.Label;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface LabelRepository extends JpaRepository<Label, Integer> {
    List<Label> findByLabelNumStringLike(String labelNumString);

    List<Label> findByLabelContentStringLike(String labelContentString);

    List<Label> findByLabelGroupId(int labelGroupId);

    void deleteById(String labelNum);
}
