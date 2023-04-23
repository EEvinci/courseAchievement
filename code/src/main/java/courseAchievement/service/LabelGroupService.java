package courseAchievement.service;

import java.util.*;
import courseAchievement.exception.ResourceNotFoundException;
import courseAchievement.formbean.LabelGroupForm;
import courseAchievement.entity.LabelGroupEntity;

public interface LabelGroupService {

    public List<LabelGroupForm> findAllLabelGroup() throws ResourceNotFoundException;
    public LabelGroupForm findLabelGroupById(Integer iid) throws ResourceNotFoundException;
    public Integer createOneLabelGroup(LabelGroupEntity labelGroupEntity) throws  ResourceNotFoundException;
    public Integer updateOneLabelGroup(LabelGroupEntity labelGroupEntity) throws  ResourceNotFoundException;
    public Integer deleteOneLabelGroup(Integer iid) throws  ResourceNotFoundException;


}
