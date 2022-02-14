package by.epam.java.functions.impl;

import by.epam.java.application.utils.Maths;
import by.epam.java.entity.CustomArray;
import by.epam.java.functions.IFunction;
import org.apache.logging.log4j.Level;

/**
 * Determining the average value of array elements
 **/
public class ArrayAverFunction implements IFunction<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        operation[0] = Maths.getAverageScore(array.getArray());
        array.setAverage((int)operation[0]);
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Determining the average value of array elements";
            addString[1] = "The Average score:";
            logger.printf(Level.INFO, "%s%n %s%n %.1f%n",
                    addString[0], addString[1], operation[0]);
        } finally {
            IFunction.super.setDefaults();
        }
    }
}
