package by.epam.taskArray.testService;

import by.epam.taskArray.application.util.JMath;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChangeElementsTest {

    /**
     * Test arrays
     **/
    private final Number[] array = {3, 4, 1, 2, 7, 6};
    private final Number[] modded = {3, 1, 7};

    @Test
    void changeArrayTest() {
        assertThat(Arrays.equals(
                JMath.changeArrayElements(array), modded)).isEqualTo(true);
    }
}
