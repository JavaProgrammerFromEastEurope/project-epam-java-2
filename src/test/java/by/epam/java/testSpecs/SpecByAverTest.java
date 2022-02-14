package by.epam.java.testSpecs;

import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import by.epam.java.specifications.impl.AverSpecification;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class SpecByAverTest {

    final private static String TEST_STRING = "First Test array";
    final Object[] fArray = {3, 4, 1, 2, 7, 6};
    final Object[] sArray = {3, 8, 2, 9, 6, 10};
    final CustomArray fTestArray = new CustomArray(fArray);
    final CustomArray sTestArray = new CustomArray(sArray);
    final CustomRepository repository = CustomRepository.getInstance();

    void initRepositoryEntity() {
        fTestArray.setName(TEST_STRING);
        sTestArray.setName("Second Test array");

        fTestArray.setId(3);
        sTestArray.setId(2);

        fTestArray.setAverage(3.0D);
        sTestArray.setAverage(3.8D);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByAverTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Average: %s",
                repository.query(new AverSpecification(3.8))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificHigherAverTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by High Average: %s",
                repository.query(new AverSpecification(3.5), true)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificBelowAverTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Below Average: %s",
                repository.query(new AverSpecification(3.4), false)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
