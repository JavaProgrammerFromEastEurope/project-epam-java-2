package by.epam.taskArray.testSpec;

import by.epam.taskArray.application.specification.impl.IdSpecification;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.taskArray.application.util.Const.logger;

public class SpecByIdTest {

    private final Number[] fArray = {3, 4, 1, 2, 7, 6, 9, 10};
    private final Number[] sArray = {3, 8, 2, 9, 6, 10};
    private final CustomArray fTestArray = new CustomArray(fArray);
    private final CustomArray sTestArray = new CustomArray(sArray);
    private final CustomRepository repository = CustomRepository.getInstance();

    private void initRepositoryEntity() {
        fTestArray.setId(3);
        sTestArray.setId(2);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByIdTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by ID: %s",
                repository.query(new IdSpecification(2L))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
