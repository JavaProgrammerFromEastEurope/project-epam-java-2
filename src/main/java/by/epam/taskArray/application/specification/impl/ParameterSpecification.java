package by.epam.taskArray.application.specification.impl;

import by.epam.taskArray.application.specification.Specification;
import by.epam.taskArray.application.util.EnumParam;
import by.epam.taskArray.entity.CustomArray;

public record ParameterSpecification(EnumParam param, double value)
        implements Specification<CustomArray> {

    @Override
    public boolean specify(CustomArray array) {
        return array.getParam(param) == value;
    }

    @Override
    public boolean specify(CustomArray array, boolean higher) {
        return higher
                ? array.getParam(param) > value
                : array.getParam(param) < value;
    }
}
