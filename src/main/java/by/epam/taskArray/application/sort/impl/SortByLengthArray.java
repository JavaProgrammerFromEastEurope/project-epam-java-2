package by.epam.taskArray.application.sort.impl;

import by.epam.taskArray.application.sort.SortTemplate;
import by.epam.taskArray.entity.CustomArray;

/**
 * Overriding Compare method of the Comparator interface
 * to compare two arrays by array length.
 */
public class SortByLengthArray implements SortTemplate<CustomArray> {

    @Override
    public int compare(CustomArray a1, CustomArray a2) {
        return a1.getArray().length - a2.getArray().length;
    }
}