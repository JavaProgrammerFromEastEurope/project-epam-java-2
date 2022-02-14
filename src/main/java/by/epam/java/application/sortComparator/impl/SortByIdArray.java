package by.epam.java.application.sortComparator.impl;
import by.epam.java.application.sortComparator.ISortTemplate;
import by.epam.java.entity.CustomArray;

public class SortByIdArray implements ISortTemplate<CustomArray> {

    @Override
    public int compare(CustomArray a1, CustomArray a2) {
        return (int) (a2.getId() - a1.getId());
    }
}