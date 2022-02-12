package by.epam.java.application.sortComparator;

import java.util.Comparator;

public interface ISortTemplate<T> extends Comparator<T> {
    int compare(T o1, T o2);
}
