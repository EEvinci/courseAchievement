package courseAchievement.controller;

import courseAchievement.entity.LabelEntity;
import courseAchievement.repository.LabelEntityRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {

    private final LabelEntityRepository repository;

    LabelController(LabelEntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据标签编号查找标签
     * 
     * @param labelNum
     * @return
     */
    @PostMapping("/queryLabelByNum/{labelNum}")
    public LabelEntity queryLabelByNum(@PathVariable("labelNum") String labelNum) {
        LabelEntity label = LabelEntity.builder().labelNumString(labelNum).build(); // 创建一个标签对象
        // 查询数据库中的课程
        List<LabelEntity> labelList = repository.findByLabelNumStringLike(labelNum);
        // 判断是否查找到
        if (labelList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        label = labelList.get(0);
        System.out.println("Found it");
        return label;
    }

    /**
     * 添加标签
     * 
     * @param labelNum
     * @param labelContent
     * @return
     */
    @PostMapping("/addLabel/{labelNum}/{labelContent}")
    public LabelEntity addlabel(@PathVariable("labelNum") String labelNum,
            @PathVariable("labelContent") String labelContent) {
        LabelEntity label = LabelEntity.builder().labelNumString(labelNum).labelContentString(labelContent).build();
        // 保存到数据库
        repository.save(label);
        // 判断是否保存成功
        if (repository.findByLabelNumStringLike(labelNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return label;
    }

    @PostMapping("updateLabel/{labelNum}/{labelContent}")
    public LabelEntity updateLabel(@PathVariable("labelNum") String labelNum,
            @PathVariable("labelContent") String labelContent) {
        LabelEntity label = LabelEntity.builder().labelNumString(labelNum).labelContentString(labelContent).build();
        // 保存到数据库
        repository.save(label);
        // 判断是否保存成功
        if (repository.findByLabelNumStringLike(labelNum).size() == 0) {
            System.out.println("Update Failed");
            return null;
        }
        return label;
    }

    /**
     * 查看所有标签
     * 
     * @return
     */
    @PostMapping("/findAllLabel")
    public List<LabelEntity> findAll() {
        List<LabelEntity> labelList = repository.findAll();
        // 判断是否查找到
        if (labelList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return labelList;
    }

    /**
     * 根据标签编号删除标签
     * 
     * @param labelNum
     */
    @PostMapping("/deleteLabel/{labelNum}")
    public void delete(@PathVariable String labelNum) {
        repository.deleteById(labelNum);
        // 判断是否删除成功
        if (repository.findByLabelNumStringLike(labelNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }
}