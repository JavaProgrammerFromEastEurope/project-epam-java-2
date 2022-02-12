package by.epam.java.entity;

import java.util.HashMap;

public class CustomWarehouse {

    private final HashMap<Long, CustomArray> staticArrays = new HashMap<>();

    private static final CustomWarehouse instance = new CustomWarehouse();

    public void add(CustomArray array) {
        staticArrays.put(array.getId(), array);
    }

    public CustomArray remove(long index) {
        return staticArrays.remove(index);
    }

    public CustomArray get(long index) {
        return staticArrays.get(index);
    }

    public static CustomWarehouse getInstance() {
        return instance;
    }
}
