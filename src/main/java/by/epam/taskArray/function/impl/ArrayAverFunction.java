package by.epam.taskArray.function.impl;

import by.epam.taskArray.application.util.Const;
import by.epam.taskArray.application.util.JMath;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.function.Function;
import org.apache.logging.log4j.Level;

/**
 * Determining the average value of array elements
 **/
public class ArrayAverFunction implements Function<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        operation[0] = JMath.getAverageScore(array.getArray());
        array.getStatusArray().setAverage(operation[0]);
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Determining the average value of array elements";
            addString[1] = "The Average score:";
            Const.logger.printf(Level.INFO, "%s%n %s%n %.1f%n",
                    addString[0], addString[1], operation[0]);
        } finally {
            Function.super.setDefaults();
        }
    }
}
