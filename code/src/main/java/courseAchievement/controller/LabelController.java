package courseAchievement.controller;

import org.springframework.web.bind.annotation.*;
import courseAchievement.model.Label;

import java.util.UUID;

@RestController
@RequestMapping("/label")
public class LabelController {

    //根据编号找标签
    @GetMapping("/queryLabelByNum/{labelNum}")
    public Label queryLabelByNum(@PathVariable("labelNum") String labelNum) {
        Label label = new Label();
        label.setLabelNum(labelNum);
        System.out.println("Found it");
        return label;
    }

    //添加标签
    @PostMapping("/addLabel/{labelNum}/{labelContent}")
    public Label addLabel(@PathVariable("labelNum") String labelNum,
                          @PathVariable("labelContent") String labelContent) {
        Label label = new Label();
        String preUuid = UUID.randomUUID().toString();
        label.setId(preUuid);
        label.setLabelNum(labelNum);
        label.setLabelContent(labelContent);
        System.out.println("Successfully add the label which number is "+labelNum);
        return label;
    }

    //更新标签
    @PostMapping("/updateLabel/{labelNum}/{labelContent}")
    public Label updateLabel(@PathVariable("labelNum") String labelNum,
                          @PathVariable("labelContent") String labelContent) {
        Label label = new Label();
        label.setLabelNum(labelNum);
        label.setLabelContent(labelContent);
        System.out.println("Successfully update the label which number is "+labelNum);
        return label;
    }

    //删除标签
    @DeleteMapping("/deleteLabel/{labelNum}")
    public String deleteLabel(@PathVariable("labelNum") String labelNum) {
        String str = "Successfully delete the label which number is " + labelNum;
        return str;
    }
}
