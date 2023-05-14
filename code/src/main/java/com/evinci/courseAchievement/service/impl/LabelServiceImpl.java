package courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courseAchievement.exception.ResourceNotFoundException;

import courseAchievement.service.LabelService;
import courseAchievement.formbean.LabelForm;
import courseAchievement.entity.LabelEntity;
import courseAchievement.repository.LabelEntityRepository;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelEntityRepository labelEntityRepository;

    @Override
    public List<LabelForm> findAllLabel() throws ResourceNotFoundException {
        List<LabelEntity> oldList = labelEntityRepository.findAll();
        if (oldList == null) {
            throw new ResourceNotFoundException("No label found!");
        }
        List<LabelForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            LabelForm labelForm = new LabelForm();
            labelForm.setIid(oldList.get(i).getId());
            labelForm.setLabelId(oldList.get(i).getLabelNum());
            labelForm.setLabelContent(oldList.get(i).getLabelContent());
            labelForm.setLabelGroupIid(oldList.get(i).getLabelGroupId());
            newList.add(labelForm);
        }
        return newList;
    }

    @Override
    public LabelForm findLabelById(Integer iid) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLabelById'");
    }

    @Override
    public Integer createOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneLabel'");
    }

    @Override
    public Integer updateOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneLabel'");
    }

    @Override
    public Integer deleteOneLabel(Integer iid) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneLabel'");
    }
}