package by.epam.java.testSorts;

import by.epam.java.application.sortComparator.impl.SortByNameArray;
import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class SortByNameTest {

    final Object[] fArray = {3, 4, 1, 2, 7, 6};
    final Object[] sArray = {3, 8, 2, 9, 6, 7};
    final CustomArray fTestArray = new CustomArray(fArray);
    final CustomArray sTestArray = new CustomArray(sArray);
    final CustomRepository repository = CustomRepository.getInstance();

    void initRepositoryEntity() {
        fTestArray.setName("First Test array");
        sTestArray.setName("Second Test array");

        fTestArray.setId(3);
        sTestArray.setId(2);

        repository.add(fTestArray);
        repository.add(sTestArray);
    }

    @Test
    void sortByNameArrayTest() {
        initRepositoryEntity();
        logger.printf(Level.INFO, "Sort by Name: %s",
                repository.getAll().stream()
                        .sorted(new SortByNameArray())
                        .map(CustomArray::getName)
                        .collect(Collectors.toList()));
    }
}
