package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public record CountSpecification(double quantity) implements ISpecification<CustomArray> {

    public boolean specify(CustomArray array) {
        return (double) array.getQuantity() == quantity;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (double) array.getQuantity() > quantity
                : (double) array.getQuantity() < quantity;
    }
}
