package by.epam.java.functions.impl;

import by.epam.java.application.utils.Sort;
import by.epam.java.entity.CustomArray;
import by.epam.java.functions.IFunction;
import org.apache.logging.log4j.Level;

/** Finding min/max of array **/
public class ArraySortFunction implements IFunction<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        Sort.sortHoare(array.getArray(),0, array.getArray().length-1);
        operation[1] = (int)array.getArray()[0];
        operation[2] = (int)array.getArray()[array.getArray().length-1];
        array.setMin((int)operation[1]);
        array.setMax((int)operation[2]);
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Finding min/max values of array";
            addString[1] = "Max value is:";
            addString[2] = "Min value is:";
            addString[3] = String.valueOf(operation[1]);
            addString[4] = String.valueOf(operation[2]);
            logger.printf(Level.INFO,"%s%n %s%n %s%n %s%n %s%n",addString[0],
                    addString[1], addString[4], addString[2], addString[3]);
        } finally {
            IFunction.super.setDefaults();
        }
    }
}
