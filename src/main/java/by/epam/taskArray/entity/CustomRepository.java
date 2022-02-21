package by.epam.taskArray.entity;

import by.epam.taskArray.application.sort.SortTemplate;
import by.epam.taskArray.application.specification.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomRepository {
    private final Map<Long, CustomArray> mapOfArrays = new HashMap<>();

    private static final CustomRepository instance = new CustomRepository();

    public void add(CustomArray array) {
        mapOfArrays.put(array.getId(), array);
    }

    public CustomArray remove(long index) {
        return mapOfArrays.remove(index);
    }

    public CustomArray get(long index) {
        return mapOfArrays.get(index);
    }

    public static CustomRepository getInstance() {
        return instance;
    }

    public List<CustomArray> getAll() {
        return mapOfArrays.values().stream().toList();
    }

    public List<CustomArray> query(Specification<CustomArray> specification) {
        return mapOfArrays.values().stream()
                .filter(specification::specify).collect(Collectors.toList());
    }

    public List<CustomArray> query(Specification<CustomArray> specification, boolean higher) {
        return higher
                ? mapOfArrays.values().stream()
                .filter(array -> specification.specify(array, true))
                .collect(Collectors.toList())
                : mapOfArrays.values().stream()
                .filter(array -> specification.specify(array, false))
                .collect(Collectors.toList());
    }

    public List<CustomArray> sort(SortTemplate<CustomArray> arraySortTemplate) {
        return mapOfArrays.values().stream()
                .sorted(arraySortTemplate).collect(Collectors.toList());
    }

    public List<Object[]> sortByElements(
            SortTemplate<Number> numberSortTemplate, boolean higher) {
        return higher
                ? mapOfArrays.values().stream()
                .map((CustomArray array) -> array.sort(numberSortTemplate))
                .collect(Collectors.toList())
                : mapOfArrays.values().stream()
                .map((CustomArray array) -> array.sort(numberSortTemplate.reversed()))
                .collect(Collectors.toList());
    }
}
