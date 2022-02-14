package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public record MinSpecification(double min) implements ISpecification<CustomArray> {

    public boolean specify(CustomArray array) {
        return (double) array.getMin() == min;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (double) array.getMin() > min
                : (double) array.getMin() < min;
    }
}
