package com.evinci.courseAchievement.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.evinci.courseAchievement.formbean.ExampleForm;
import com.evinci.courseAchievement.service.ExampleService;
import com.evinci.courseAchievement.exception.ResourceNotFoundException;
import com.evinci.courseAchievement.entity.ExampleEntity;
import com.evinci.courseAchievement.repository.ExampleEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleEntityRepository exampleEntityRepository;

    @Override
    public List<ExampleForm> findAllExample() throws ResourceNotFoundException {
        List<ExampleEntity> oldList = exampleEntityRepository.findAll();
        if (oldList.size() == 0) {
            throw new ResourceNotFoundException("No example found!");
        }
        List<ExampleForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            ExampleForm exampleForm = new ExampleForm();
            exampleForm.setIid(oldList.get(i).getId());
            exampleForm.setExampleId((oldList.get(i)).getExampleNum());
            exampleForm.setExampleUrl(oldList.get(i).getExampleContent());
            newList.add(exampleForm);
        }

        return newList;
    }

    @Override
    public ExampleForm findExampleById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findExampleById'");
    }

    @Override
    public Integer updateOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneExample'");
    }

    @Override
    public Integer createOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneExample'");
    }

    @Override
    public Integer deleteOneExample(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneExample'");
    }
}