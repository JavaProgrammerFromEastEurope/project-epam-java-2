package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public class IdSpecification implements ISpecification<CustomArray> {
    private final Long id;

    public IdSpecification(Long id) {
        this.id = id;
    }

    public boolean specify(CustomArray array) {
        return array.getId() == id;
    }
}
