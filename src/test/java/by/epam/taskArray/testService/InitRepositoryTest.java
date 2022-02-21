package by.epam.taskArray.testService;

import by.epam.taskArray.application.observer.impl.ArrayObserver;
import by.epam.taskArray.application.util.Init;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import by.epam.taskArray.entity.CustomWarehouse;
import by.epam.taskArray.entity.ParameterArray;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static by.epam.taskArray.application.util.Const.logger;

public class InitRepositoryTest {

    /**
     * Test repository
     **/
    private final CustomRepository repository = new CustomRepository();

    private CustomArray fArray;
    private CustomArray sArray;
    private CustomArray tArray;

    private void initRepositoryEntity() {
        fArray = new CustomArray(new Number[]{1, 3, 6, 4, 2, 5}, 1);
        sArray = new CustomArray(new Number[]{1, 3, 2, 3, 5, 7}, 2);
        tArray = new CustomArray(new Number[]{6, 3, 2, 6, 8, 3}, 3);
        repository.add(fArray);
        repository.add(sArray);
        repository.add(tArray);
    }

    private void initRepoRandomValues(CustomRepository repository) {
        for (int i = 1; i <= 3; i++) {
            fArray = new CustomArray(
                    Init.initLineObjects(true, false, 6), i);
            repository.add(fArray);
        }
    }

    private List<String> getListOfString(List<? extends ParameterArray> list) {
        return list.stream()
                .map(ParameterArray::getArray)
                .map(Arrays::toString).toList();
    }

    @Test
    void initRepoFromFile() {
        initRepositoryEntity();
        CustomRepository fRepository = Init.getArraysFromFile();
        List<String> values = getListOfString(fRepository.getAll());
        List<String> repos = getListOfString(repository.getAll());
        logger.printf(Level.DEBUG, "Repo from init %s", values);
        logger.printf(Level.DEBUG, "Repo from file %s", repos);
    }

    @Test
    void initRepoRandomValues() {
        CustomRepository fRepository = new CustomRepository();
        initRepoRandomValues(fRepository);
        List<String> values = getListOfString(fRepository.getAll());
        logger.printf(Level.DEBUG, "Repo rand values: %s", values);
    }

    @Test
    void initWarehouse() {
        ArrayObserver.events.subscribe(
                "update", ArrayObserver.getInstance());
        CustomWarehouse warehouse = CustomWarehouse.getInstance();
        initRepositoryEntity();
        warehouse.addAll(repository);
        List<String> values = getListOfString(warehouse.getAll());
        logger.printf(Level.DEBUG, "Warehouse : %s", values);
    }
}
