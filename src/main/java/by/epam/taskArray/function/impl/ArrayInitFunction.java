package by.epam.taskArray.function.impl;

import by.epam.taskArray.application.util.Init;
import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.function.Function;
import org.apache.logging.log4j.Level;

import java.util.Arrays;

import static by.epam.taskArray.application.util.Const.logger;
import static by.epam.taskArray.application.util.Input.getInteger;

/**
 * Init of array elements
 **/
public class ArrayInitFunction implements Function<CustomArray> {

    @Override
    public void calcFunction(CustomArray array) {
        operation[0] = getInteger("Input length of array:");
        array.setArray(
                Init.initLineObjects(true, true, (int) operation[0] - 1));
    }

    @Override
    public void getResultString(CustomArray array) {
        try {
            addString[0] = "Init of array elements";
            addString[1] = "Custom array:";
            logger.printf(Level.INFO, "%s%n %s%n %s%n",
                    addString[0], addString[1], Arrays.toString(array.getArray()));
        } finally {
            Function.super.setDefaults();
        }
    }
}