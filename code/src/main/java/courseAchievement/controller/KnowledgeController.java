package courseAchievement.controller;

import courseAchievement.entity.KnowledgeEntity;
import courseAchievement.repository.KnowledgeEntityRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    private final KnowledgeEntityRepository repository;

    KnowledgeController(KnowledgeEntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据知识点编号查找知识点
     * 
     * @param knowledgeNum
     * @return
     */
    @PostMapping("/queryKnowledgeByNum/{knowledgeNum}")
    public KnowledgeEntity queryKnowledgeByNum(@PathVariable("knowledgeNum") String knowledgeNum) {
        KnowledgeEntity knowledge = KnowledgeEntity.builder().knowledgeNumString(knowledgeNum).build(); // 创建一个课程对象
        // 查询数据库中的课程
        List<KnowledgeEntity> knowledgeList = repository.findByKnowledgeNumStringLike(knowledgeNum);
        // 判断是否查找到
        if (knowledgeList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        knowledge = knowledgeList.get(0);
        System.out.println("Found it");
        return knowledge;
    }

    /**
     * 添加知识点
     * 
     * @param knowledgeNum
     * @param knowledgeDescription
     * @param knowledgeVital
     * @param preKnowledgeId
     * @return
     */
    @PostMapping("/addKnowledge/{knowledgeNum}/{knowledgeDescription}/{knowledgeVital}/{preKnowledgeId}")
    public KnowledgeEntity addKnowledge(@PathVariable("knowledgeNum") String knowledgeNum,
            @PathVariable("knowledgeDescription") String knowledgeDescription,
            @PathVariable("knowledgeVital") String knowledgeVital,
            @PathVariable("preKnowledgeId") Integer preKnowledgeId) {
        KnowledgeEntity knowledge = KnowledgeEntity.builder().knowledgeNumString(knowledgeNum)
                .knowledgeDescriptionString(knowledgeDescription)
                .knowledgeVitalString(knowledgeVital).PreknowledgeId(preKnowledgeId).build();
        // 保存到数据库
        repository.save(knowledge);
        // 判断是否保存成功
        if (repository.findByKnowledgeNumStringLike(knowledgeNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return knowledge;
    }

    /**
     * 查看所有
     * 
     * @return
     */
    @PostMapping("/findAllKnowledge")
    public List<KnowledgeEntity> findAll() {
        List<KnowledgeEntity> knowledgeList = repository.findAll();
        // 判断是否查找到
        if (knowledgeList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return knowledgeList;
    }

    /**
     * 根据知识点编号删除知识点
     * 
     * @param knowledgeNum
     */
    @PostMapping("/deleteKnowledge/{knowledgeNum}")
    public void delete(@PathVariable String knowledgeNum) {
        repository.deleteById(knowledgeNum);
        // 判断是否删除成功
        if (repository.findByKnowledgeNumStringLike(knowledgeNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }
}