package by.epam.taskArray.function;

import static java.util.Arrays.fill;


public interface Function<T> {

    String[] addString = new String[5];
    double[] operation = new double[5];

    default void setDefaults() {
        fill(operation, 0);
        fill(addString, null);
    }

    void calcFunction(T array);

    void getResultString(T array);
}