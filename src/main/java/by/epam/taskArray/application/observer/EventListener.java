package by.epam.taskArray.application.observer;

import by.epam.taskArray.entity.CustomArray;

public interface EventListener {
    void update(String eventType, CustomArray array);
}
