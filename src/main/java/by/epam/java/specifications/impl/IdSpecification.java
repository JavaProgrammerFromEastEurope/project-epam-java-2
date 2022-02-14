package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;

public record IdSpecification(Long id) implements ISpecification<CustomArray> {

    public boolean specify(CustomArray array) {
        return array.getId() == id;
    }
}
