package by.epam.taskArray.application.sort.impl;

import by.epam.taskArray.application.sort.SortTemplate;
import by.epam.taskArray.entity.CustomArray;

/**
 * Overriding Compare method of the Comparator interface
 * to compare two arrays by array id.
 */
public class SortByIdArray implements SortTemplate<CustomArray> {

    @Override
    public int compare(CustomArray a1, CustomArray a2) {
        return (int) (a1.getId() - a2.getId());
    }
}