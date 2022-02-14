package by.epam.java.functions.impl;

import by.epam.java.application.utils.Init;
import by.epam.java.entity.CustomArray;
import by.epam.java.functions.IFunction;
import org.apache.logging.log4j.Level;

import java.util.Arrays;

import static by.epam.java.application.utils.Input.getInteger;

/**
 * Init of array elements
 **/
public class ArrayInitFunction implements IFunction<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        variables[0] = getInteger("Input length of array:");
        array.setArray(Init.initLineObjects(true,true, (int)variables[0]-1));
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Init of array elements";
            addString[1] = "Custom array:";
            logger.printf(Level.INFO, "%s%n %s%n %s%n",
                    addString[0], addString[1], Arrays.toString(array.getArray()));
        } finally {
            IFunction.super.setDefaults();
        }
    }
}