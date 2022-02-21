package by.epam.taskArray.testService;

import by.epam.taskArray.application.util.JMath;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindAverageTest {

    /**
     * Test array
     **/
    private final Number[] array = {1, 2, 3, 4, 5};

    @Test
    void changeArrayTest() {
        assertThat(JMath.getAverageScore(array)).isEqualTo(3);
    }
}
