package courseAchievement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import courseAchievement.entity.KnowledgePoint;

import java.util.List;

/**
 * @author evinci
 * @version 1.0
 */
public interface KnowledgePointRepository extends JpaRepository<KnowledgePoint, Integer> {
    List<KnowledgePoint> findByKnowledgePointNumStringLike(String knowledgePointNumString);

    List<KnowledgePoint> findByKnowledgePointVitalString(String knowledgePointVitalString);

    List<KnowledgePoint> findByKnowledgePointDescriptionString(String knowledgePointDescriptionString);

    void deleteById(String knowledgePointNum);

}
