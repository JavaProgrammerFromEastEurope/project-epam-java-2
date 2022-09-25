package by.epam.taskArray.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomWarehouse {

    private static final CustomWarehouse instance = new CustomWarehouse();

    public static CustomWarehouse getInstance() {
        return instance;
    }

    private final Map<Long, StatusArray> arrays = new HashMap<>();

    public void add(CustomArray array) {
        arrays.put(array.getId(), array.getStatusArray());
    }

    public void addAll(CustomRepository repository) {
        for (CustomArray array : repository.getAll()) {
            arrays.put(array.getId(), array.getStatusArray());
        }
    }

    public List<StatusArray> getAll() {
        return new ArrayList<>(arrays.values());
    }

    public StatusArray get(long index) {
        return arrays.get(index);
    }

    public StatusArray remove(long index) {
        return arrays.remove(index);
    }
}
