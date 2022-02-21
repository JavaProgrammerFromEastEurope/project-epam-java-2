package by.epam.taskArray.testSpec;

import by.epam.taskArray.application.specification.impl.ParameterSpecification;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.taskArray.application.util.Const.logger;
import static by.epam.taskArray.application.util.EnumParam.MAX;

public class SpecByMaxTest {

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

        fTestArray.getStatusArray().setMax(7);
        sTestArray.getStatusArray().setMax(10);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Max: %s",
                repository.query(new ParameterSpecification(MAX, 10L))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificHigherMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by High Max: %s",
                repository.query(new ParameterSpecification(MAX, 8L), true)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificBelowMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Below Max: %s",
                repository.query(new ParameterSpecification(MAX, 8L), false)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
