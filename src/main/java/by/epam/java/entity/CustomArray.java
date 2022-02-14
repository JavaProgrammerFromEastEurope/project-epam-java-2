package by.epam.java.entity;

import by.epam.java.observers.EventManager;
import org.apache.logging.log4j.Level;

import static by.epam.java.functions.IFunction.logger;

public class CustomArray {
    private long id;
    private String name;
    final private double[] statusArray = new double[4];
    final public static EventManager events = new EventManager("update");
    private Object[] array;

    public CustomArray(Object[] array) {
        this.array = array;
        events.notify("update", this);
    }

    public void setArray(Object[] array) {
        this.array = array;
        events.notify("update", this);
    }

    public void updateElement(int index, Object element) {
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

    public long getId() {
        return id;
    }

    public Object getAverage() {
        return statusArray[0];
    }

    public Object getMax() {
        return statusArray[1];
    }

    public Object getMin() {
        return statusArray[2];
    }

    public Object getQuantity() {
        return statusArray[3];
    }

    public void setAverage(double value) {
        statusArray[0] = value;
    }

    public void setMax(int value) {
        statusArray[1] = value;
    }

    public void setMin(int value) {
        statusArray[2] = value;
    }

    public void setQuantity(int value) {
        statusArray[3] = value;
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

    public Object[] getArray() {
        return array;
    }
}