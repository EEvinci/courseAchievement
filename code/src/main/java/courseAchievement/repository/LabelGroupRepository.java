package courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.LabelGroup;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface LabelGroupRepository extends JpaRepository<LabelGroup, Integer> {
    List<LabelGroup> findByLabelGroupNumStringLike(String labelGroupNumString);

    List<LabelGroup> findByLabelGroupContentStringLike(String labelGroupContentsString);

    void deleteById(String labelGroupNum);
}
