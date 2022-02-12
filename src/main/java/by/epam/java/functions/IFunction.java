package by.epam.java.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.util.Arrays.fill;

public interface IFunction<T> {

    Logger logger = LogManager.getLogger(IFunction.class);

    String[] addString = new String[6];
    double[] variables = new double[3];
    double[] operation = new double[4];

    default void setDefaults() {
        fill(operation, 0);
        fill(variables, 0);
        fill(addString, null);
    }

    void calcFunction(T array);

    void getResultString(T array);
}