package by.epam.java.functions.impl;

import by.epam.java.entity.CustomArray;
import by.epam.java.functions.IFunction;
import org.apache.logging.log4j.Level;

/**
 * Determination the count of array elements
 **/
public class ArrayCountFunction implements IFunction<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        operation[0] = array.getArray().length;
        array.setQuantity((int)operation[0]);
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Determination the count of array elements.";
            addString[1] = "Count of array elements:";
            logger.printf(Level.INFO, "%s%n %s%n %s%n",
                    addString[0], addString[1], operation[0]);
        } finally {
            IFunction.super.setDefaults();
        }

    }
}
