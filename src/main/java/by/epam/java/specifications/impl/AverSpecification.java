package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public class AverSpecification implements ISpecification<CustomArray> {
    private final Long average;

    public AverSpecification(Long aver) {
        this.average = aver;
    }

    public boolean specify(CustomArray array) {
        return array.getAverage() == average;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (int)array.getAverage() > average
                : (int)array.getAverage() < average;
    }
}
