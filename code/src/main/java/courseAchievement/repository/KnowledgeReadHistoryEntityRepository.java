package courseAchievement.repository;

import courseAchievement.entity.KnowledgeReadHistoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KnowledgeReadHistoryEntityRepository extends JpaRepository<KnowledgeReadHistoryEntity, Integer> {

    Integer countByKnowledgeIid(Integer knowledgeIid);

    Page<KnowledgeReadHistoryEntity> findByKnowledgeIid(Integer knowledgIid, Pageable pageable);
}