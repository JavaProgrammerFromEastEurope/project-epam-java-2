package by.epam.java.testSpecs;

import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import by.epam.java.specifications.impl.NameSpecification;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class SpecByNameTest {

    final private static String TEST_STRING = "First Test array";
    final Object[] fArray = {3, 4, 1, 2, 7, 6};
    final Object[] sArray = {3, 8, 2, 9, 6, 7};
    final CustomArray fTestArray = new CustomArray(fArray);
    final CustomArray sTestArray = new CustomArray(sArray);
    final CustomRepository repository = CustomRepository.getInstance();

    void initRepositoryEntity() {
        fTestArray.setName(TEST_STRING);
        sTestArray.setName("Second Test array");

        fTestArray.setId(3);
        sTestArray.setId(2);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void specificByIdTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Specific by Name: %s",
                repository.query(new NameSpecification(TEST_STRING))
                        .stream()
                        .map(CustomArray::getArray)
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
