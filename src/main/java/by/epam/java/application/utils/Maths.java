package by.epam.java.application.utils;

public final class Maths {

    public static int countByTypeValues(Object[] array, Boolean bPos, int first, int last) {
        int inc = bPos ? 1 : 0, inv = bPos ? 0 : 1;
        return first == last
                ? (int)array[first] > 0 ? inc : inv
                : (int)array[first] > 0
                    ? inc + countByTypeValues(array, bPos, ++first, last)
                    : inv + countByTypeValues(array, bPos, ++first, last);
    }

    public static int sumOfIndexValues(Object[] array, int first, int last) {
        return first == last ? (int)array[first]
                    : sumOfIndexValues(array, first, first)
                    + sumOfIndexValues(array, ++first, last);
    }

    public static double getAverageScore(Object[] array) {
        return  (double) sumOfIndexValues
                (array, 0, array.length-1) / array.length;
    }

    public static Object[] changeArrayElements(Object[] array) {
        int localBound = array.length;
        int index = 0;
        Object[] modded = new Object[(localBound + localBound % 2) / 2];
        for (int step = 0; step < localBound; step += 2) {
            modded[index++] = array[step];
        }
        return modded;
    }
}