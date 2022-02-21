package by.epam.taskArray.application.util;

import java.util.Comparator;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

/**
 * The <em><b>Sort</b></em> class - provides methods for efficient sorting.
 */
public final class Sort {

    /**
     * Method for sorting matrix objects
     *
     * @param objectComparator - used by sortComparator classes
     */
    public static Object[][] sortMatrixObjects(Number[][] matrix, Comparator<Number> objectComparator) {
        int localBound = matrix.length;
        IntStream.range(0, localBound)
                .forEach(i -> matrix[i] = sortLineObjects(matrix[i], objectComparator));
        return matrix;
    }

    /**
     * Method for sorting one dim arrays
     *
     * @param objectComparator - used by sortComparator classes
     */
    public static Number[] sortLineObjects(Number[] lineObjects, Comparator<Number> objectComparator) {
        lineObjects = (Number[]) stream(lineObjects).sorted(objectComparator).toArray();
        return lineObjects;
    }

    /**
     * 'Hoare Sort' - The most ultimate sorting method
     *
     * @param low  - the lowest value by section
     * @param high - the highest value by section
     */
    public static Number[] sortHoare(Number[] objectsArray, int low, int high) {
        if (low >= high || objectsArray.length == 0) {
            throw new IllegalStateException();
        }
        int middle = low + (high - low) / 2;
        int middleValue = (int) objectsArray[middle];
        int i = low, j = high;
        while (i <= j) {
            while ((int) objectsArray[i] < middleValue) i++;
            while ((int) objectsArray[j] > middleValue) j--;
            if (i > j) {
                break;
            }
            int temp = (int) objectsArray[i];
            objectsArray[i] = objectsArray[j];
            objectsArray[j] = temp;
            i++;
            j--;
        }
        if (low < j) {
            sortHoare(objectsArray, low, j);
        }
        if (high > i) {
            sortHoare(objectsArray, i, high);
        }
        return objectsArray;
    }

    /**
     * 'Shells Sort' - is an optimization of insertion sort
     * that allows the exchange of items that are far apart.
     */
    public static void sortShells(Number[] arraySample) {
        for (int step = arraySample.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arraySample.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if ((int) arraySample[j] < (int) arraySample[j + step]) {
                        break;
                    }
                    int x = (int) arraySample[j];
                    arraySample[j] = arraySample[j + step];
                    arraySample[j + step] = x;
                }
            }
        }
    }

    /**
     * 'Selection Sort' -
     * The algorithm divides the input list into two parts:
     * a sorted sublist of items which is built up from left to right
     * and a sublist of the remaining unsorted items
     * that occupy the rest of the list.
     */
    public static void sortSelection(Number[] arraySample) {
        int pos, temp;
        int localBound = arraySample.length;
        for (int index = 0; index < localBound; index++) {
            for (int i = pos = index; i < localBound; i++)
                if ((int) arraySample[pos] <= (int) arraySample[i]) {
                    pos = i;
                }
            if (pos == index) {
                continue;
            }
            temp = (int) arraySample[index];
            arraySample[index] = arraySample[pos];
            arraySample[pos] = temp;
        }
    }

    /**
     * 'Insert Sort' -
     * Insertion sort is a simple sorting algorithm
     * that builds the final sorted array (or list) one item at a time.
     */
    public static void sortInsert(Number[] arraySample) {
        int value, index;
        for (int i = 1; i < arraySample.length; i++) {
            value = (int) arraySample[i];
            for (index = i - 1; index >= 0; index--) {
                if (value >= (int) arraySample[index]) {
                    break;
                }
                arraySample[index + 1] = arraySample[index];
            }
            arraySample[index + 1] = value;
        }
    }

    /**
     * 'Exchange Sort' -
     * it compares elements of the array and swaps
     * those that are out of order.
     */
    public static void sortExchange(Number[] arraySample) {
        int localBound = arraySample.length, temp;
        for (int step = 0; step < localBound; step++) {
            for (int index = 0; index < localBound - 1; index++)
                if ((int) arraySample[index] <= (int) arraySample[index + 1]) {
                    temp = (int) arraySample[index];
                    arraySample[index] = arraySample[index + 1];
                    arraySample[index + 1] = temp;
                }
        }
    }
}