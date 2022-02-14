package by.epam.java.testSpecs;

import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import by.epam.java.specifications.impl.MinSpecification;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class SpecByMinTest {

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

        fTestArray.setMin(1);
        sTestArray.setMin(2);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByMinTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Min: %s",
                repository.query(new MinSpecification(2))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificHigherMinTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by High Min: %s",
                repository.query(new MinSpecification(1), true)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificBelowMinTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Below Min: %s",
                repository.query(new MinSpecification(2), false)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
