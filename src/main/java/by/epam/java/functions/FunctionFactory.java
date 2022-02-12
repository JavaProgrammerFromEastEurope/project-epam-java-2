package by.epam.java.functions;

import by.epam.java.entity.CustomArray;
import by.epam.java.functions.impl.*;

import java.util.HashMap;

public class FunctionFactory {

    private final HashMap<Integer, IFunction<CustomArray>> serviceFunctions = new HashMap<>();

    private static final FunctionFactory instance = new FunctionFactory();

    private FunctionFactory(){
        serviceFunctions.put(1, new ArrayInitFunction());
        serviceFunctions.put(2, new ArrayAverFunction());
        serviceFunctions.put(3, new ArraySortFunction());
        serviceFunctions.put(4, new ArrayCountFunction());
    }

    public HashMap<Integer, IFunction<CustomArray>> getServiceFunctions() {
        return serviceFunctions;
    }

    public static FunctionFactory getInstance() {
        return instance;
    }
}
