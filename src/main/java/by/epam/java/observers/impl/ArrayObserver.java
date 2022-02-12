package by.epam.java.observers.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.functions.FunctionFactory;
import by.epam.java.functions.IFunction;
import by.epam.java.observers.IObserver;

import java.util.HashMap;

import static java.util.stream.IntStream.rangeClosed;

public class ArrayObserver implements IObserver<CustomArray> {

    private final HashMap<Integer, IFunction<CustomArray>>
            serviceFunctions = FunctionFactory.getInstance().getServiceFunctions();

    @Override
    public void observe(CustomArray array) {
        rangeClosed(2, 4).forEach(i -> {
            serviceFunctions.get(i).calcFunction(array);
            serviceFunctions.get(i).getResultString(array);
        });
    }
}
