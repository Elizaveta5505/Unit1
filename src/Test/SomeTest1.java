package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.coverage.MoodAnalyser;
import ru.geekbrains.coverage.SomeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


class SomeTest1 {
    private SomeService some;
        @BeforeEach
        void setUp() {
            some = new SomeService();
        }

        @Test
        void multipleTreeNotFiveReturnsFizz() {
            assertEquals("Fizz", some.fizzBuzz(3));
        }

        @Test
        void multipleFiveNotTreeReturnsBuzz() {
            assertEquals("Buzz", some.fizzBuzz(5));
        }

        @Test
        void multipleTreeAndFifteenReturnsFizzBuzz() {
        assertEquals("FizzBuzz", some.fizzBuzz(15));
        }

        @Test
        void notMultipleTreeAndFiveReturnsNumber() {
        assertEquals(Integer.toString(1), some.fizzBuzz(1));
        }

        @Test
        void firstLast() {
            assertTrue(some.firstLast6(new int[]{6,4,3}));
            assertTrue(some.firstLast6(new int[]{1,4,6}));
            assertFalse(some.firstLast6(new int[]{2,4,3}));
        }

    @Test
    void calculatingCorrectDiscount() {
        assertThat(some.calculatingDiscount(100, 10)).isEqualTo(90);
        assertThat(some.calculatingDiscount(100, 100)).isEqualTo(0);
        assertThat(some.calculatingDiscount(100, 0)).isEqualTo(100);
    }

    @Test
    void negativePurchaseAmountReturnsException() {
        assertThatThrownBy(() -> some.calculatingDiscount(-1000, 10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Отрицательная сумма заказа!!!");
    }

    @Test
    void negativeDiscountReturnsException() {
        assertThatThrownBy(() -> some.calculatingDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Не верная скидка! 0% - 100%");
    }

    @Test
    void more100DiscountReturnsException() {
        assertThatThrownBy(() -> some.calculatingDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class).hasMessage("Не верная скидка! 0% - 100%");
    }

    @Test
    void correctLuckySum() {
        assertThat(some.luckySum(2, 3, 4)).isEqualTo(9);
        assertThat(some.luckySum(13, 3, 4)).isEqualTo(7);
        assertThat(some.luckySum(2, 13, 4)).isEqualTo(6);
        assertThat(some.luckySum(2, 3, 13)).isEqualTo(5);
    }

    @Test
    void moodAnalyser() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("Это грустное сообщение");

        assertThat(mood).isEqualTo("Sad");
    }

    @Test
    void testHappyMoodAnalyser() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("Это веселое сообщение");

        assertThat(mood).isEqualTo("Happy");
    }

    @Test
    void evenOddNumber() {
        assertTrue(some.evenOddNumber(4));
        assertFalse(some.evenOddNumber(7));
    }


    @Test
    void numberInInterval() {
        assertTrue(some.numberInInterval(45));
        assertFalse(some.numberInInterval(9));
    }

    }


