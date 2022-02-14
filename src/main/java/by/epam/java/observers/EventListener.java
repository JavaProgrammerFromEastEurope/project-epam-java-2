package by.epam.java.observers;

import by.epam.java.entity.CustomArray;

public interface EventListener {
    void update(String eventType, CustomArray array);
}
