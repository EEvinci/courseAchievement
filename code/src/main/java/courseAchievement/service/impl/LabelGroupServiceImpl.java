package courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courseAchievement.exception.ResourceNotFoundException;

import courseAchievement.service.LabelGroupService;
import courseAchievement.formbean.LabelGroupForm;
import courseAchievement.entity.LabelGroupEntity;
import courseAchievement.repository.LabelGroupEntityRepository;

@Service
public class LabelGroupServiceImpl implements LabelGroupService {

    @Autowired
    private LabelGroupEntityRepository labelGroupEntityRepository;

    @Override
    public List<LabelGroupForm> findAllLabelGroup() throws ResourceNotFoundException {

        List<LabelGroupEntity> oldList = labelGroupEntityRepository.findAll();
        if (oldList == null) {
            throw new ResourceNotFoundException("No label group found!");
        }
        List<LabelGroupForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            LabelGroupForm labelGroupForm = new LabelGroupForm();
            labelGroupForm.setIid(oldList.get(i).getId());
            labelGroupForm.setLabelGroupId(oldList.get(i).getLabelGroupNum());
            labelGroupForm.setLabelGroupDescription(oldList.get(i).getLabelGroupContent());
            newList.add(labelGroupForm);
        }

        return newList;

    }

    @Override
    public LabelGroupForm findLabelGroupById(Integer iid) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLabelGroupById'");
    }

    @Override
    public Integer createOneLabelGroup(LabelGroupEntity labelGroupEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneLabelGroup'");
    }

    @Override
    public Integer updateOneLabelGroup(LabelGroupEntity labelGroupEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneLabelGroup'");
    }

    @Override
    public Integer deleteOneLabelGroup(Integer iid) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneLabelGroup'");
    }
}