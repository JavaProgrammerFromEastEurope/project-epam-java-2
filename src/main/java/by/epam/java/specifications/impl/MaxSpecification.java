package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public class MaxSpecification implements ISpecification<CustomArray> {
    private final Long max;

    public MaxSpecification(Long max) {
        this.max = max;
    }

    public boolean specify(CustomArray array) {
        return array.getMax() == max;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (int)array.getMax() > max
                : (int)array.getMax() < max;
    }
}
