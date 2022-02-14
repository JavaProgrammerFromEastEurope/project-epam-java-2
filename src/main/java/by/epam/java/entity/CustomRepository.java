package by.epam.java.entity;

import by.epam.java.specifications.ISpecification;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRepository {
    private final HashMap<Long, CustomArray> mapOfArrays = new HashMap<>();

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

    public List<CustomArray> query(ISpecification<CustomArray> specification) {
        return mapOfArrays.values().stream()
                .filter(specification::specify).collect(Collectors.toList());
    }

    public List<CustomArray> query(ISpecification<CustomArray> specification, boolean higher) {
        return higher
                ? mapOfArrays.values().stream()
                    .filter(array -> specification.specify(array, true))
                    .collect(Collectors.toList())
                : mapOfArrays.values().stream()
                    .filter(array -> specification.specify(array, false))
                    .collect(Collectors.toList());
    }
}
