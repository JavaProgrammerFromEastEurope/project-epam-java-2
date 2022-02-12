package by.epam.java.application.sortComparator.impl;
import by.epam.java.application.sortComparator.ISortTemplate;
import by.epam.java.entity.CustomArray;

public class SortByNameArray implements ISortTemplate<CustomArray> {

    @Override
    public int compare(CustomArray a1, CustomArray a2) {
        return a1.getName().compareTo(a2.getName());
    }
}