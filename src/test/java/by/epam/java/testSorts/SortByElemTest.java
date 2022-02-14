package by.epam.java.testSorts;

import by.epam.java.application.sortComparator.impl.SortByHigherObject;
import by.epam.java.application.utils.Sort;
import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class SortByElemTest {

    final Object[] fArray = {3, 4, 1, 2, 7, 6};
    final Object[] sArray = {3, 8, 2, 9, 6, 7};
    final CustomArray fTestArray = new CustomArray(fArray);
    final CustomArray sTestArray = new CustomArray(sArray);
    final CustomRepository repository = CustomRepository.getInstance();

    void initRepositoryEntity() {
        fTestArray.setName("First  Test array");
        sTestArray.setName("Second Test array");

        fTestArray.setId(3);
        sTestArray.setId(2);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void sortByElemArrayTest() {
        initRepositoryEntity();
        logger.printf(Level.INFO, "Sort by Elements: %s",
                repository.getAll().stream()
                        .map(CustomArray::getArray)
                        .map((Object[] lineObjects)
                                -> Sort.sortLineObjects(
                                lineObjects, new SortByHigherObject().reversed()))
                        .map(Arrays::toString)
                        .collect(Collectors.toList()));
    }
}
