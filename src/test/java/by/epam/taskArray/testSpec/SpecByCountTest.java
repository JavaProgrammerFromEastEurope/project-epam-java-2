package by.epam.taskArray.testSpec;

import by.epam.taskArray.application.specification.impl.ParameterSpecification;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.taskArray.application.util.Const.logger;
import static by.epam.taskArray.application.util.EnumParam.LENGTH;

public class SpecByCountTest {

    private static final String TEST_STRING = "First Test array";
    private final Number[] fArray = {3, 4, 1, 2, 7, 6, 9, 10};
    private final Number[] sArray = {3, 8, 2, 9, 6, 10};
    private final CustomArray fTestArray = new CustomArray(fArray);
    private final CustomArray sTestArray = new CustomArray(sArray);
    private final CustomRepository repository = CustomRepository.getInstance();

    private void initRepositoryEntity() {
        fTestArray.setName(TEST_STRING);
        sTestArray.setName("Second Test array");

        fTestArray.setId(3);
        sTestArray.setId(2);

        fTestArray.getStatusArray().setLength(8);
        sTestArray.getStatusArray().setLength(6);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Count: %s",
                repository.query(new ParameterSpecification(LENGTH, 8))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificHigherCountTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by High Count: %s",
                repository.query(new ParameterSpecification(LENGTH, 7), true)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificBelowCountTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Below Count: %s",
                repository.query(new ParameterSpecification(LENGTH, 7), false)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
