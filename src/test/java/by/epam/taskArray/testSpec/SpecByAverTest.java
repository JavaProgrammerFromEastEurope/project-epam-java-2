package by.epam.taskArray.testSpec;

import by.epam.taskArray.application.specification.impl.ParameterSpecification;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.taskArray.application.util.Const.logger;
import static by.epam.taskArray.application.util.EnumParam.AVER;

public class SpecByAverTest {

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
        fTestArray.getStatusArray().setAverage(3.0D);
        sTestArray.getStatusArray().setAverage(3.8D);
        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByAverTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Average: %s",
                repository.query(new ParameterSpecification(AVER, 3.8))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificHigherAverTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by High Average: %s",
                repository.query(new ParameterSpecification(AVER, 3.5), true)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificBelowAverTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Below Average: %s",
                repository.query(new ParameterSpecification(AVER, 3.4), false)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
