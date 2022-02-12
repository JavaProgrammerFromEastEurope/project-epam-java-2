package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public class MinSpecification implements ISpecification<CustomArray> {
    private final Long min;

    public MinSpecification(Long min) {
        this.min = min;
    }

    public boolean specify(CustomArray array) {
        return array.getMin() == min;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (int)array.getMin() > min
                : (int)array.getMin() < min;
    }
}
