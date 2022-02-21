package by.epam.taskArray.testService;

import by.epam.taskArray.application.util.JMath;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindPosNegValTest {

    /**
     * Test array
     **/
    private final Number[] array = {-1, 2, -3, 4, -5};

    @Test
    void findPosValTest() {
        assertThat(JMath.countByTypeValues
                (array, true, 0, array.length - 1)).isEqualTo(2);
    }

    @Test
    void findNegValTest() {
        assertThat(JMath.countByTypeValues
                (array, false, 0, array.length - 1)).isEqualTo(3);
    }
}
