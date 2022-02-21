package by.epam.taskArray.testSort;

import by.epam.taskArray.application.sort.impl.SortByIdArray;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static by.epam.taskArray.application.util.Const.logger;


public class SortByIdTest {

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
    void sortByIdArrayTest() {
        initRepositoryEntity();
        logger.printf(Level.DEBUG, "Sort by ID: %s",
                repository.getAll().stream()
                        .sorted(new SortByIdArray())
                        .map(CustomArray::getId)
                        .collect(Collectors.toList()));
    }
}
