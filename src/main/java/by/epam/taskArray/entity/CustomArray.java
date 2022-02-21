package by.epam.taskArray.entity;

import by.epam.taskArray.application.util.EnumParam;
import org.apache.logging.log4j.Level;

import java.util.Arrays;
import java.util.Comparator;

import static by.epam.taskArray.application.observer.impl.ArrayObserver.events;
import static by.epam.taskArray.application.util.Const.logger;

public class CustomArray extends ParameterArray {
    private long id;
    private String name;

    private final StatusArray statusArray = new StatusArray();

    public CustomArray(Number[] array, int id) {
        super(array);
        this.id = id;
        events.notify("update", this);
    }

    public CustomArray(Number[] array) {
        super(array);
        events.notify("update", this);
    }

    public void updateElement(int index, Number element) {
        if (index > 0) {
            if (index < array.length) {
                array[index] = element;
                events.notify("update", this);
            } else {
                logger.printf(Level.ERROR, "Inputted %s greater then %s!", index, array.length);
            }
        } else {
            logger.printf(Level.ERROR, "Inputted %s less then %s!", index, 0);
        }
    }

    public Number[] getArray() {
        return array;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArray(Number[] array) {
        this.array = array;
        events.notify("update", this);
    }

    public StatusArray getStatusArray() {
        return statusArray;
    }

    public double getParam(EnumParam param) {
        return switch (param) {
            case MAX -> statusArray.getMax();
            case MIN -> statusArray.getMin();
            case AVER -> statusArray.getAverage();
            case LENGTH -> statusArray.getQuantity();
        };
    }

    public Object[] sort(Comparator<Number> arraySortTemplate) {
        return Arrays.stream(array)
                .sorted(arraySortTemplate).toArray();
    }
}