package by.epam.java.entity;

import by.epam.java.observers.IObserver;
import by.epam.java.specifications.ISpecification;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRepository implements IObserver<CustomArray> {
    private final HashMap<Long, CustomArray> mapOfArrays = new HashMap<>();

    private static final CustomWarehouse instance = new CustomWarehouse();

    public void add(CustomArray array) {
        mapOfArrays.put(array.getId(), array);
    }

    public CustomArray remove(long index) {
        return mapOfArrays.remove(index);
    }

    public CustomArray get(long index) {
        return mapOfArrays.get(index);
    }

    public static CustomWarehouse getInstance() {
        return instance;
    }
    public List<CustomArray> query(ISpecification<CustomArray> specification) {
        return mapOfArrays.values()
                .stream().filter(specification::specify).collect(Collectors.toList());
    }

    @Override
    public void observe(CustomArray array) {

    }
}
