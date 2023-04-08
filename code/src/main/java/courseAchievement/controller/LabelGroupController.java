package courseAchievement.controller;

import courseAchievement.Entity.LabelGroup;
import courseAchievement.repository.LabelGroupRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/labelGroup")
public class LabelGroupController {

    private final LabelGroupRepository repository;

    LabelGroupController(LabelGroupRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据标签组编号查找标签组
     * 
     * @param labelGroupNum
     * @return
     */
    @PostMapping("/querylabelGroupByNum/{labelGroupNum}")
    public LabelGroup queryLabelGroupByNum(@PathVariable("labelGroupNum") String labelGroupNum) {
        LabelGroup labelGroup = LabelGroup.builder().labelGroupNumString(labelGroupNum).build(); // 创建一个标签组对象
        // 查询数据库中的课程
        List<LabelGroup> labelGroupList = repository.findByLabelGroupNumStringLike(labelGroupNum);
        // 判断是否查找到
        if (labelGroupList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        labelGroup = labelGroupList.get(0);
        System.out.println("Found it");
        return labelGroup;
    }

    /**
     * 添加标签组
     * 
     * @param labelGroupNum
     * @param labelGroupContent
     * @return
     */
    @PostMapping("/addLabelGroup/{labelGroupNum}/{labelGroupContent}")
    public LabelGroup addlabelGroup(@PathVariable("labelGroupNum") String labelGroupNum,
            @PathVariable("labelGroupContent") String labelGroupContent) {
        LabelGroup labelGroup = LabelGroup.builder().labelGroupNumString(labelGroupNum)
                .labelGroupContentString(labelGroupContent).build();
        // 保存到数据库
        repository.save(labelGroup);
        // 判断是否保存成功
        if (repository.findByLabelGroupNumStringLike(labelGroupNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return labelGroup;
    }

    /**
     * 查看所有标签组
     * 
     * @return
     */
    @PostMapping("/findAllLabelGroup")
    public List<LabelGroup> findAll() {
        List<LabelGroup> labelGroupList = repository.findAll();
        // 判断是否查找到
        if (labelGroupList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return labelGroupList;
    }

    /**
     * 根据标签组编号删除标签组
     * 
     * @param labelGroupNum
     */
    @PostMapping("/deleteLabelGroup/{labelGroupNum}")
    public void delete(@PathVariable String labelGroupNum) {
        repository.deleteById(labelGroupNum);
        // 判断是否删除成功
        if (repository.findByLabelGroupNumStringLike(labelGroupNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }
}
