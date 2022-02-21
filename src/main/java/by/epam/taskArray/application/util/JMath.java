package by.epam.taskArray.application.util;

/**
 * The <em><b>Maths</b></em> class - provides methods for efficient using of math methods.
 */
public final class JMath {

    /**
     * Count elements by required type of elements
     *
     * @param array - the object array
     * @param bPos  - switch between pos and neg elements
     * @param first - starting position for searching elements
     * @param last  -  final position for searching elements
     */
    public static int countByTypeValues(Number[] array, Boolean bPos, int first, int last) {
        int inc = bPos ? 1 : 0, inv = bPos ? 0 : 1;
        return first == last
                ? (int) array[first] > 0 ? inc : inv
                : (int) array[first] > 0
                ? inc + countByTypeValues(array, bPos, ++first, last)
                : inv + countByTypeValues(array, bPos, ++first, last);
    }

    /**
     * Finds sum of array elements
     *
     * @param first - starting position
     * @param last  - final position
     */
    public static int sumOfIndexValues(Number[] array, int first, int last) {
        return first == last ? (int) array[first]
                : sumOfIndexValues(array, first, first)
                + sumOfIndexValues(array, ++first, last);
    }

    /**
     * Finds the average score by array elements
     */
    public static double getAverageScore(Number[] array) {
        return (double) sumOfIndexValues
                (array, 0, array.length - 1) / array.length;
    }

    /**
     * Return modified array with requirement elements:
     *
     * @return All odd elements from default array
     */
    public static Object[] changeArrayElements(Number[] array) {
        int localBound = array.length;
        int index = 0;
        Object[] modded = new Object[(localBound + localBound % 2) / 2];
        for (int step = 0; step < localBound; step += 2) {
            modded[index++] = array[step];
        }
        return modded;
    }
}