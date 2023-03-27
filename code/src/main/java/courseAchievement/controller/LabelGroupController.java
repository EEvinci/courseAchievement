package courseAchievement.controller;

import org.springframework.web.bind.annotation.*;
import courseAchievement.model.LabelGroup;

import java.util.UUID;

@RestController
@RequestMapping("/labelGroup")
public class LabelGroupController {

    //根据编号找标签组
    @GetMapping("/queryLabelGroupByNum/{labelGroupNum}")
    public LabelGroup queryLabelGroupByNum(@PathVariable("labelGroupNum") String labelGroupNum) {
        LabelGroup labelGroup = new LabelGroup();
        labelGroup.setLabelGroupNum(labelGroupNum);
        System.out.println("Found it");
        return labelGroup;
    }

    //添加标签组
    @PostMapping("/addLabelGroup/{labelGroupNum}/{labelGroupContent}")
    public LabelGroup addLabelGroup(@PathVariable("labelGroupNum") String labelGroupNum,
                          @PathVariable("labelGroupContent") String[] labelGroupContent) {
        LabelGroup labelGroup = new LabelGroup();
        String preUuid = UUID.randomUUID().toString();
        labelGroup.setId(preUuid);
        labelGroup.setLabelGroupNum(labelGroupNum);
        labelGroup.setLabelGroupContent(labelGroupContent);
        System.out.println("Successfully add the label group which number is "+labelGroupNum);
        return labelGroup;
    }

    //更新标签组
    @PostMapping("/updateLabelGroup/{labelGroupNum}/{labelGroupContent}")
    public LabelGroup updateLabelGroup(@PathVariable("labelGroupNum") String labelGroupNum,
                             @PathVariable("labelGroupContent") String[] labelGroupContent) {
        LabelGroup labelGroup = new LabelGroup();
        labelGroup.setLabelGroupNum(labelGroupNum);
        labelGroup.setLabelGroupContent(labelGroupContent);
        System.out.println("Successfully update the label group which number is "+labelGroupNum);
        return labelGroup;
    }

    //删除标签组
    @DeleteMapping("/deleteLabelGroup/{labelGroupNum}")
    public String deleteLabelGroup(@PathVariable("labelGroupNum") String labelGroupNum) {
        String str = "Successfully delete the label which number is " + labelGroupNum;
        return str;
    }
}
