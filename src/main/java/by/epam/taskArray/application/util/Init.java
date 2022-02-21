package by.epam.taskArray.application.util;

import by.epam.taskArray.entity.CustomArray;
import by.epam.taskArray.entity.CustomRepository;
import org.apache.logging.log4j.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.nio.file.Files.newBufferedReader;

/**
 * The <em><b>Init</b></em> class - provides methods for
 * init data arrays from files or random numbers.
 */
public final class Init {

    private static final String PATH = "files/array.txt";
    private static final Pattern newLine = Pattern.compile("[\\n]");
    private static final Pattern isDigit = Pattern.compile("[\\d+]");
    private static final Pattern literal = Pattern.compile("[a-z]");

    /**
     * Read all lines from required File - Maven variation
     *
     * @return String From File
     */
    public static String getStringFromFile(String filePath)
            throws IOException, URISyntaxException {
        String stringFromFile;
        URL url = Init.class.getResource(format("/%s", filePath));
        Path path = Paths.get(url.toURI());
        try (BufferedReader bufferedReader = newBufferedReader(path)) {
            stringFromFile = bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
            return stringFromFile;
        }
    }

    /**
     * Finds all Digit elements from the line and parse them to a Number Array
     * Using - Scanner with Digit pattern
     *
     * @return Number Array
     */
    public static Number[] getDigitArrayFromString(String line) {
        return new Scanner(line).findAll(isDigit)
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .toArray(Number[]::new);
    }

    /**
     * Finds all UnLiteral Strings and converts them to Repository of Arrays
     *
     * @return Repository
     */
    public static CustomRepository getArraysFromFile() {
        CustomArray tempArray;
        CustomRepository repository = new CustomRepository();
        String stringFromFile;
        try {
            stringFromFile = getStringFromFile(PATH);
            List<String> stringList =
                    Arrays.stream(newLine.split(stringFromFile))
                            .collect(Collectors.toCollection(ArrayList::new));
            int counter = 0;
            for (String line : stringList) {
                if (literal.split(line).length == 1) {
                    tempArray = new CustomArray(
                            getDigitArrayFromString(line), ++counter);
                    repository.add(tempArray);
                }
            }
        } catch (IOException | URISyntaxException e) {
            Const.logger.printf(Level.ERROR,
                    "File with path '%s' cannot be read!", PATH);
        }
        return repository;
    }

    /**
     * Returns array of number objects by Boolean Parameter
     *
     * @return Number[]
     */
    public static Number[] initLineObjects(Boolean bInteger, Boolean bPositive, int bound) {
        Number[] lineArray = new Number[bound];
        initObjects(bInteger, bPositive, lineArray, bound);
        return lineArray;
    }

    /**
     * Init array by random Number objects
     *
     * @param bInteger  - return (int, double) values
     * @param bPositive - return (below zero, higher zero) values
     */
    public static void initObjects(Boolean bInteger, Boolean bPositive, Number[] objects, int bound) {
        int negativeValue = bPositive ? 0 : 16;
        for (int index = 0; index < bound; index++) {
            if (bInteger) {
                objects[index] = ThreadLocalRandom.current().nextInt(32) + 1 - negativeValue;
            } else {
                objects[index] = ThreadLocalRandom.current().nextDouble(32) + 1 - negativeValue;
            }
        }
    }
}
