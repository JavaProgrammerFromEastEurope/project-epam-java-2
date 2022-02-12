package by.epam.java.specifications.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.specifications.ISpecification;


public class NameSpecification implements ISpecification<CustomArray> {
    private final String subString;

    public NameSpecification(String subString) {
        this.subString = subString;
    }

    public boolean specify(CustomArray array) {
        return array.getName().contains(subString);
    }
}