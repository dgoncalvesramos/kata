import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FizzBuzzTest {

    @DisplayName("The value tested is not a mutiple of three, five and seven, so the return must be the value")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 92})
    public void notMultipleOfThreeOrFiveOrSevenTest(int input) {
        String expected = Integer.toString(input);
        assertEquals(expected, FizzBuzz.fizzBuzz(input));
    }

    @ParameterizedTest
    @CsvSource({"3, Fizz", "5, Buzz", "7, Vozz", "63, FizzVozz", "21, FizzVozz", "35, BuzzVozz"})
    public void mutipleTest(int input, String expectedResult) {
        assertEquals(expectedResult, FizzBuzz.multiple(input));
    }

    @ParameterizedTest
    @CsvSource({"73, VozzFizz", "35, FizzBuzz"})
    public void containsTest(int input, String expectedResult) {
        assertEquals(expectedResult, FizzBuzz.contains(input));
    }

    @ParameterizedTest
    @CsvSource({"73, VozzFizz", "28, Vozz", "35, BuzzVozzFizzBuzz"})
    public void fizzBuzzTest(int input, String expectedResult){
        assertEquals(expectedResult, FizzBuzz.fizzBuzz(input));
    }

}
