package by.epam.taskArray.application.specification.impl;

import by.epam.taskArray.application.specification.Specification;
import by.epam.taskArray.entity.CustomArray;

public record NameSpecification(String subString)
        implements Specification<CustomArray> {

    @Override
    public boolean specify(CustomArray array) {
        return array.getName().contains(subString);
    }
}