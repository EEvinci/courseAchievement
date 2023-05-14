package courseAchievement.service;

import java.util.List;
import courseAchievement.exception.ResourceNotFoundException;
import courseAchievement.formbean.ExampleForm;
import courseAchievement.entity.ExampleEntity;;

public interface ExampleService {
    public List<ExampleForm> findAllExample() throws ResourceNotFoundException;

    public ExampleForm findExampleById(Integer id) throws ResourceNotFoundException;

    public Integer updateOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException;

    public Integer createOneExample(ExampleEntity exampleEntity) throws ResourceNotFoundException;

    public Integer deleteOneExample(Integer id) throws ResourceNotFoundException;
}
