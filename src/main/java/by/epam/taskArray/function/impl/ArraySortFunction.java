package by.epam.taskArray.function.impl;

import by.epam.taskArray.application.util.Const;
import by.epam.taskArray.application.util.Sort;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.function.Function;
import org.apache.logging.log4j.Level;

/**
 * Finding min/max of array
 **/
public class ArraySortFunction implements Function<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        Sort.sortHoare(array.getArray(), 0, array.getArray().length - 1);
        operation[0] = (int) array.getArray()[0];
        operation[1] = (int) array.getArray()[array.getArray().length - 1];
        array.getStatusArray().setMin((int) operation[0]);
        array.getStatusArray().setMax((int) operation[1]);
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Finding min/max values of array";
            addString[1] = "Max value is:";
            addString[2] = "Min value is:";
            addString[3] = String.valueOf(operation[0]);
            addString[4] = String.valueOf(operation[1]);
            Const.logger.printf(Level.INFO, "%s%n %s%n %s%n %s%n %s%n", addString[0],
                    addString[1], addString[4], addString[2], addString[3]);
        } finally {
            Function.super.setDefaults();
        }
    }
}
