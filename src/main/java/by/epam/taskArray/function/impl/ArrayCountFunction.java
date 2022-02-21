package by.epam.taskArray.function.impl;

import by.epam.taskArray.application.util.Const;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.function.Function;
import org.apache.logging.log4j.Level;

/**
 * Determination the count of array elements
 **/
public class ArrayCountFunction implements Function<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        operation[0] = array.getArray().length;
        array.getStatusArray().setLength((int) operation[0]);
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Determination the count of array elements.";
            addString[1] = "Count of array elements:";
            Const.logger.printf(Level.INFO, "%s%n %s%n %s%n",
                    addString[0], addString[1], operation[0]);
        } finally {
            Function.super.setDefaults();
        }
    }
}
