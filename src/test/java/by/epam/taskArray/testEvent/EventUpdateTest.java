package by.epam.taskArray.testEvent;

import by.epam.taskArray.application.observer.impl.ArrayObserver;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.junit.jupiter.api.Test;

public class EventUpdateTest {

    private final Number[] fArray = {3, 4, 1, 2, 7, 6};
    private final CustomRepository repository = CustomRepository.getInstance();
    private final ArrayObserver arrayObserver = ArrayObserver.getInstance();

    private void initRepositoryEntity() {
        CustomArray fTestArray = new CustomArray(fArray);

        fTestArray.setName("First  Test array");
        fTestArray.setId(1);
        repository.add(fTestArray);
    }

    @Test
    void subscribeCustomArray() {
        initRepositoryEntity();
        ArrayObserver.events.subscribe(
                "update", arrayObserver);
        repository.get(1).updateElement(2, 3);
    }

    @Test
    void unsubscribeCustomArray() {
        ArrayObserver.events.subscribe(
                "update", arrayObserver);
        initRepositoryEntity();
        ArrayObserver.events.unsubscribe(
                "update", arrayObserver);
        repository.get(1).updateElement(2, 3);
    }
}
