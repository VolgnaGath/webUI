package org.example.lesson4;

import org.example.Lesson4.Box;
import org.example.Lesson4.BoxIsEmptyException;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BoxTest {
    Box box;
    @Nested
    class WhenBoxIsEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }
        @Test
        void excemptionDeleteBall() {
            Assertions.assertThrows(BoxIsEmptyException.class, () -> box.deleteBall());
            assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.deleteBall());
        }
        @Nested
        class WhenOneBall {
            @BeforeEach
            void addball() {
                box.addBall();
            }
            @Test
            void deleteBallTest() throws BoxIsEmptyException {
                box.deleteBall();
                assertThat(box.getBallsCount()).isEqualTo(0);
            }
        }
    }

}
