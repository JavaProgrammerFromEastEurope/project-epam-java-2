package by.epam.java.observers.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.functions.FunctionFactory;
import by.epam.java.functions.IFunction;
import by.epam.java.observers.EventListener;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static by.epam.java.functions.IFunction.logger;


public class ArrayObserver implements EventListener {

    private final HashMap<Integer, IFunction<CustomArray>>
            serviceFunctions = FunctionFactory.getInstance().getServiceFunctions();

    private static final ArrayObserver instance = new ArrayObserver();

    private ArrayObserver(){}

    @Override
    public void update(String eventType, CustomArray array) {
        logger.printf(Level.WARN, "Someone has performed %s event.%n", eventType);
        for (int i = 2; i <= 4; i++) {
            serviceFunctions.get(i).calcFunction(array);
            serviceFunctions.get(i).getResultString(array);
        }
    }

    public static ArrayObserver getInstance() {
        return instance;
    }
}
