package by.epam.java.entity;

import java.util.HashMap;

public class CustomWarehouse {
    private final HashMap<Long, CustomArray> arrays = new HashMap<>();

    private static final CustomWarehouse instance = new CustomWarehouse();

    public void add(CustomArray array) {
        arrays.put(array.getId(), array);
    }

    public CustomArray remove(long index) {
        return arrays.remove(index);
    }

    public CustomArray get(long index) {
        return arrays.get(index);
    }

    public static CustomWarehouse getInstance() {
        return instance;
    }
}
