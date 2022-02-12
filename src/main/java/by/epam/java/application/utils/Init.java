package by.epam.java.application.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.nio.file.Files.newBufferedReader;

public final class Init {

    private static final String PATH = "files/array.txt";
    private static final Pattern newLine = Pattern.compile("[\\n]");
    private static final Pattern isDigit = Pattern.compile("[\\d+]");
    private static final Pattern literal = Pattern.compile("[a-z]");

    public static String getStringFromFile() {
        var stringFromFile = "";
        try (BufferedReader bufferedReader = newBufferedReader(
                Paths.get(Objects.requireNonNull(Init.class.getResource(format("/%s", PATH))).toURI()))) {
            stringFromFile = (bufferedReader.lines().collect(Collectors.joining("\n")));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return stringFromFile;
    }

    public static Object[] initArrayFromFile() {
        ArrayList<String> stringList = Arrays.stream(newLine.split(getStringFromFile()))
                .collect(Collectors.toCollection(ArrayList::new));
        for (String line : stringList) {
            if (literal.split(line).length == 1) {
                return new Scanner(line).findAll(isDigit)
                        .map(MatchResult::group).map(Integer::parseInt).toArray();
            }
        }
        return new Object[]{};
    }

    public static Object[] initLineObjects(Boolean bInteger, Boolean bPositive, int bound) {
        Object[] lineArray = new Object[bound];
        initObjects(bInteger, bPositive, lineArray, bound);
        return lineArray;
    }

    public static void initObjects(Boolean bInteger, Boolean bPositive, Object[] objects, int bound) {
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
