package courseAchievement.controller;

import courseAchievement.Entity.KnowledgePoint;
import courseAchievement.repository.KnowledgePointRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/knowledgePoint")
public class KnowledgePointController {

    private final KnowledgePointRepository repository;

    KnowledgePointController(KnowledgePointRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据知识点编号查找知识点
     * 
     * @param knowledgePointNum
     * @return
     */
    @PostMapping("/queryKnowledgePointByNum/{knowledgePointNum}")
    public KnowledgePoint queryKnowledgePointByNum(@PathVariable("knowledgePointNum") String knowledgePointNum) {
        KnowledgePoint knowledgePoint = KnowledgePoint.builder().knowledgePointNumString(knowledgePointNum).build(); // 创建一个课程对象
        // 查询数据库中的课程
        List<KnowledgePoint> knowledgePointList = repository.findByKnowledgePointNumStringLike(knowledgePointNum);
        // 判断是否查找到
        if (knowledgePointList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        knowledgePoint = knowledgePointList.get(0);
        System.out.println("Found it");
        return knowledgePoint;
    }

    /**
     * 添加知识点
     * 
     * @param knowledgePointNum
     * @param knowledgePointDescription
     * @param knowledgePointVital
     * @param preKnowledgePointId
     * @return
     */
    @PostMapping("/addKnowledgePoint/{knowledgePointNum}/{knowledgePointDescription}/{knowledgePointVital}/{preKnowledgePointId}")
    public KnowledgePoint addKnowledgePoint(@PathVariable("knowledgePointNum") String knowledgePointNum,
            @PathVariable("knowledgePointDescription") String knowledgePointDescription,
            @PathVariable("knowledgePointVital") String knowledgePointVital,
            @PathVariable("preKnowledgePointId") Integer preKnowledgePointId) {
        KnowledgePoint knowledgePoint = KnowledgePoint.builder().knowledgePointNumString(knowledgePointNum)
                .knowledgePointDescriptionString(knowledgePointDescription)
                .knowledgePointVitalString(knowledgePointVital).PreKnowledgePointId(preKnowledgePointId).build();
        // 保存到数据库
        repository.save(knowledgePoint);
        // 判断是否保存成功
        if (repository.findByKnowledgePointNumStringLike(knowledgePointNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return knowledgePoint;
    }

    /**
     * 查看所有
     * 
     * @return
     */
    @PostMapping("/findAllKnowledgePoint")
    public List<KnowledgePoint> findAll() {
        List<KnowledgePoint> knowledgePointList = repository.findAll();
        // 判断是否查找到
        if (knowledgePointList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return knowledgePointList;
    }

    /**
     * 根据知识点编号删除知识点
     * 
     * @param knowledgePointNum
     */
    @PostMapping("/deleteKnowledgePoint/{knowledgePointNum}")
    public void delete(@PathVariable String knowledgePointNum) {
        repository.deleteById(knowledgePointNum);
        // 判断是否删除成功
        if (repository.findByKnowledgePointNumStringLike(knowledgePointNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }
}