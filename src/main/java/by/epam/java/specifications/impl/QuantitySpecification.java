package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public class QuantitySpecification implements ISpecification<CustomArray> {
    private final Long quantity;

    public QuantitySpecification(Long quantity) {
        this.quantity = quantity;
    }

    public boolean specify(CustomArray array) {
        return array.getQuantity() == quantity;
    }

    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? (int)array.getQuantity() > quantity
                : (int)array.getQuantity() < quantity;
    }
}
