package by.epam.taskArray.application.observer.impl;

import by.epam.taskArray.application.observer.EventListener;
import by.epam.taskArray.application.observer.EventManager;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.function.Function;
import by.epam.taskArray.function.FunctionFactory;
import org.apache.logging.log4j.Level;

import java.util.Map;

import static by.epam.taskArray.application.util.Const.logger;

public class ArrayObserver implements EventListener {

    private static final ArrayObserver instance = new ArrayObserver();

    public static final EventManager events = new EventManager("update");
    private final Map<Integer, Function<CustomArray>>
            serviceFunctions = FunctionFactory.getInstance().getServiceFunctions();

    private ArrayObserver() {
    }

    public static ArrayObserver getInstance() {
        return instance;
    }

    @Override
    public void update(String eventType, CustomArray array) {
        logger.printf(Level.WARN,
                "Someone has performed %s event.%n", eventType);
        for (int i = 2; i <= 4; i++) {
            serviceFunctions.get(i).calcFunction(array);
            serviceFunctions.get(i).getResultString(array);
        }
    }
}
