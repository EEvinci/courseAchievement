package com.evinci.courseAchievement.controller;

import com.evinci.courseAchievement.repository.ExampleEntityRepository;
import com.evinci.courseAchievement.entity.ExampleEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {

    private final ExampleEntityRepository repository;

    ExampleController(ExampleEntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 根据案例编号查找案例
     * 
     * @param exampleNum
     * @return
     */
    @PostMapping("/queryExampleByNum/{exampleNum}")
    public ExampleEntity queryExampleByNum(@PathVariable("exampleNum") String exampleNum) {
        ExampleEntity example = ExampleEntity.builder().exampleNum(exampleNum).build(); // 创建一个课程对象
        // 查询数据库中的课程
        List<ExampleEntity> exampleList = repository.findByExampleNumString(exampleNum);
        // 判断是否查找到
        if (exampleList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        // 返回第一个
        example = exampleList.get(0);
        System.out.println("Found it");
        return example;
    }

    /**
     * 添加课程
     * 
     * @param exampleNum
     * @param exampleContent
     * @return
     */
    @PostMapping("/addExample/{exampleNum}/{exampleContent}")
    public ExampleEntity addExample(@PathVariable("exampleNum") String exampleNum,
            @PathVariable("exampleContent") String exampleContent) {
        ExampleEntity example = ExampleEntity.builder().exampleNum(exampleNum).exampleContent(exampleContent).build();
        // 保存到数据库
        repository.save(example);
        // 判断是否保存成功
        if (repository.findByExampleNumString(exampleNum).size() == 0) {
            System.out.println("Add Failed");
            return null;
        }
        return example;
    }

    /**
     * 查看所有案例
     * 
     * @return
     */
    @PostMapping("/findAllExample")
    public List<ExampleEntity> findAll() {
        List<ExampleEntity> exampleList = repository.findAll();
        // 判断是否查找到
        if (exampleList.size() == 0) {
            System.out.println("Not Found");
            return null;
        }
        return exampleList;
    }

    /**
     * 根据案例编号删除案例
     * 
     * @param exampleNum
     */
    @PostMapping("/deleteExample/{exampleNum}")
    public void delete(@PathVariable String exampleNum) {
        repository.deleteById(exampleNum);
        // 判断是否删除成功
        if (repository.findByExampleNumString(exampleNum).size() == 0) {
            System.out.println("Delete Success");
        } else {
            System.out.println("Delete Failed");
        }
    }

}