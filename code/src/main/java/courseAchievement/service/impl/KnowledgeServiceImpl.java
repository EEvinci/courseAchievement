package courseAchievement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courseAchievement.exception.ResourceNotFoundException;

import courseAchievement.service.KnowledgeService;
import courseAchievement.formbean.KnowledgeForm;
import courseAchievement.entity.KnowledgeEntity;
import courseAchievement.repository.KnowledgeEntityRepository;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeEntityRepository knowledgeEntityRepository;

    @Override
    public List<KnowledgeForm> findAllKnowledge() throws ResourceNotFoundException {

        List<KnowledgeEntity> oldList = knowledgeEntityRepository.findAll();
        if (oldList == null) {
            throw new ResourceNotFoundException("No knowledge found!");
        }
        List<KnowledgeForm> newList = new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            KnowledgeForm knowledgeForm = new KnowledgeForm();
            knowledgeForm.setIid(oldList.get(i).getId());
            knowledgeForm.setKnowledgeId(oldList.get(i).getKnowledgeNumString());
            knowledgeForm.setKnowledgeDescription(oldList.get(i).getKnowledgeDescriptionString());
            knowledgeForm.setKnowledgeImportantDescription(oldList.get(i).getKnowledgeVitalString());
            knowledgeForm.setPreKnowledgeIid(oldList.get(i).getPreknowledgeId());
            newList.add(knowledgeForm);
        }
        return newList;
    }

    @Override
    public Integer createOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOneKnowledge'");
    }

    @Override
    public Integer deleteOneKnowledge(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneKnowledge'");
    }

    @Override
    public KnowledgeForm findKnowledgeById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findKnowledgeById'");
    }

    @Override
    public KnowledgeForm findPreKnowledgeById(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPreKnowledgeById'");
    }

    @Override
    public List<KnowledgeForm> findAllUsingKnowledge(Integer id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllUsingKnowledge'");
    }

    @Override
    public Integer updateOneKnowledge(KnowledgeEntity knowledgeEntity) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneKnowledge'");
    }
}