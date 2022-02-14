package by.epam.java.testEvents;

import by.epam.java.application.sortComparator.impl.SortByHigherObject;
import by.epam.java.application.utils.Sort;
import by.epam.java.entity.CustomArray;
import by.epam.java.entity.CustomRepository;
import by.epam.java.observers.impl.ArrayObserver;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.epam.java.functions.IFunction.logger;

public class EventUpdateTest {

    final Object[] fArray = {3, 4, 1, 2, 7, 6};
    final Object[] sArray = {3, 8, 2, 9, 6, 7};

    final CustomRepository repository = CustomRepository.getInstance();

    void initRepositoryEntity() {
        CustomArray.events.subscribe("update",  ArrayObserver.getInstance());

        CustomArray fTestArray = new CustomArray(fArray);
        CustomArray sTestArray = new CustomArray(sArray);

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
        repository.get(2).updateElement(2,3);

    }
}
