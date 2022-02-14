package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public record MaxSpecification(double max) implements ISpecification<CustomArray> {

    public boolean specify(CustomArray array) {
        return (double) array.getMax() == max;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (double) array.getMax() > max
                : (double) array.getMax() < max;
    }
}
