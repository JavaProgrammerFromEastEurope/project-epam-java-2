package by.epam.taskArray.function;

import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.function.impl.ArrayAverFunction;
import by.epam.taskArray.function.impl.ArrayCountFunction;
import by.epam.taskArray.function.impl.ArrayInitFunction;
import by.epam.taskArray.function.impl.ArraySortFunction;

import java.util.HashMap;
import java.util.Map;

public class FunctionFactory {

    private static final FunctionFactory instance = new FunctionFactory();

    private final Map<Integer, Function<CustomArray>> serviceFunctions = new HashMap<>();

    private FunctionFactory() {
        serviceFunctions.put(1, new ArrayInitFunction());
        serviceFunctions.put(2, new ArrayAverFunction());
        serviceFunctions.put(3, new ArraySortFunction());
        serviceFunctions.put(4, new ArrayCountFunction());
    }

    public static FunctionFactory getInstance() {
        return instance;
    }

    public Map<Integer, Function<CustomArray>> getServiceFunctions() {
        return serviceFunctions;
    }
}
