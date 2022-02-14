package by.epam.java.testSpecs;

import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import by.epam.java.specifications.impl.MaxSpecification;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class SpecByMaxTest {

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

        fTestArray.setMax(7);
        sTestArray.setMax(10);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Max: %s",
                repository.query(new MaxSpecification(10L))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificHigherMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by High Max: %s",
                repository.query(new MaxSpecification(8L), true)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }

    @Test
    void specificBelowMaxTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Below Max: %s",
                repository.query(new MaxSpecification(8L), false)
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
