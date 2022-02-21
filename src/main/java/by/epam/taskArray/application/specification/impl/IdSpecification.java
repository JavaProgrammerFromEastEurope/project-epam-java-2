package by.epam.taskArray.application.specification.impl;

import by.epam.taskArray.application.specification.Specification;
import by.epam.taskArray.entity.CustomArray;

public record IdSpecification(Long id)
        implements Specification<CustomArray> {

    @Override
    public boolean specify(CustomArray array) {
        return array.getId() == id;
    }
}
