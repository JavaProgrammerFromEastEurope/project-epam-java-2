package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public record AverSpecification(double average) implements ISpecification<CustomArray> {

    public boolean specify(CustomArray array) {
        return (double) array.getAverage() == average;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (double) array.getAverage() > average
                : (double) array.getAverage() < average;
    }
}
