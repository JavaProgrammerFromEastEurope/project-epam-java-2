package by.epam.taskArray.application.sort.impl;

import by.epam.taskArray.application.sort.SortTemplate;


/**
 * Overriding Compare method of the Comparator interface
 * to compare two objects by the higher element.
 */
public class SortByArrayObjects implements SortTemplate<Number> {

    @Override
    public int compare(Number o1, Number o2) {
        return (int) o1 - (int) o2;
    }
}