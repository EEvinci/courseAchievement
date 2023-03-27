package courseAchievement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import courseAchievement.model.KnowledgePoint;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/knowledgePoint")
public class KnowledgePointController {

    //根据名称查找特定的知识点
    @GetMapping("/queryKnowledgePointByName/{knowledgePointName}")
    public KnowledgePoint queryKnowledgePointByName(@PathVariable("knowledgePointName") String knowledgePointName) {
        KnowledgePoint knowledgePoint = new KnowledgePoint();
        knowledgePoint.setKnowledgePointName(knowledgePointName);
        System.out.println("Found it");
        return knowledgePoint;
    }

    //添加知识点信息
    @RequestMapping("/addKnowledgePoint/{knowledgePointName}/{knowledgePointDescription}/{knowledgePointMainlyExplain}/{knowledgePointCase}/{knowledgePointPreview}/{knowledgePointLabel}")
    public KnowledgePoint addKnowledgePoint(@PathVariable("knowledgePointName") String knowledgePointName,
                                               @PathVariable("knowledgePointDescription") String knowledgePointDescription,
                                               @PathVariable("knowledgePointMainlyExplain") String knowledgePointMainlyExplain,
                                               @PathVariable("knowledgePointCase") String[] knowledgePointCase,
                                               @PathVariable("knowledgePointPreview") List<KnowledgePoint> knowledgePointPreview,
                                               @PathVariable("knowledgePointLabel") String[] knowledgePointLabel
    ) {
        KnowledgePoint knowledgePoint = new KnowledgePoint();
        String preUuid = UUID.randomUUID().toString();
        knowledgePoint.setId(preUuid);
        knowledgePoint.setKnowledgePointName(knowledgePointName);
        knowledgePoint.setKnowledgePointDescription(knowledgePointDescription);
        knowledgePoint.setKnowledgePointMainlyExplain(knowledgePointMainlyExplain);
        knowledgePoint.setKnowledgePointCase(knowledgePointCase);
        knowledgePoint.setKnowledgePointPreview(knowledgePointPreview);
        knowledgePoint.setKnowledgePointLabel(knowledgePointLabel);
        System.out.println("Successfully add the information of "+knowledgePointName);
        return knowledgePoint;
    }

    //更新知识点信息
    @RequestMapping("/updateKnowledgePoint/{knowledgePointName}/{knowledgePointDescription}/{knowledgePointMainlyExplain}/{knowledgePointCase}/{knowledgePointPreview}/{knowledgePointLabel}")
    public KnowledgePoint updateKnowledgePoint(@PathVariable("knowledgePointName") String knowledgePointName,
                                               @PathVariable("knowledgePointDescription") String knowledgePointDescription,
                                               @PathVariable("knowledgePointMainlyExplain") String knowledgePointMainlyExplain,
                                               @PathVariable("knowledgePointCase") String[] knowledgePointCase,
                                               @PathVariable("knowledgePointPreview") List<KnowledgePoint> knowledgePointPreview,
                                               @PathVariable("knowledgePointLabel") String[] knowledgePointLabel
                                               ) {
        KnowledgePoint knowledgePoint = new KnowledgePoint();
        knowledgePoint.setKnowledgePointName(knowledgePointName);
        knowledgePoint.setKnowledgePointDescription(knowledgePointDescription);
        knowledgePoint.setKnowledgePointMainlyExplain(knowledgePointMainlyExplain);
        knowledgePoint.setKnowledgePointCase(knowledgePointCase);
        knowledgePoint.setKnowledgePointPreview(knowledgePointPreview);
        knowledgePoint.setKnowledgePointLabel(knowledgePointLabel);
        System.out.println("Successfully update the information of "+knowledgePointName);
        return knowledgePoint;
    }

    //删除知识点信息
    @RequestMapping("/deleteKnowledgePoint/{knowledgePointName}")
    public String deteleKnowledgePoint(@PathVariable("knowledgePointName") String knowledgePointName) {
        return "Successfully delete the knowledge point named "+knowledgePointName;
    }


}
