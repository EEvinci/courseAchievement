package courseAchievement.service;

import java.util.List;

import courseAchievement.formbean.LabelForm;
import courseAchievement.entity.LabelEntity;
import courseAchievement.exception.ResourceNotFoundException;

public interface LabelService {
    public List<LabelForm> findAllLabel() throws ResourceNotFoundException;

    public LabelForm findLabelById(Integer iid) throws ResourceNotFoundException;

    public Integer createOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException;

    public Integer updateOneLabel(LabelEntity labelEntity) throws ResourceNotFoundException;

    public Integer deleteOneLabel(Integer iid) throws ResourceNotFoundException;
}
