import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringCalculatorTest {

    @DisplayName("Test if the String calculator returns 0 when the argument is the empty String")
    @Test
    public void testNullString() throws Exception {
        assertEquals(0,StringCalculator.add(""));
    }


    @DisplayName("Test the String calculator with comma delimiter")
    @ParameterizedTest
    @CsvSource({"10, '1,2,3,4'", "100,'10,10,10,10,10,10,10,10,10,10'"})
    public void testSimpleAdditionWithCommaDelimiter(int expectedResult, String numbers) throws Exception{
        assertEquals(expectedResult,StringCalculator.add(numbers));
    }

    @DisplayName("Test the String calculator with line feed delimiter")
    @ParameterizedTest
    @CsvSource({"10, '1\n2\n3,4'", "100,'10,10,10,10\n10,10,10,10,10,10'"})
    public void testSimpleAdditionWithReturnCarriageDelimiter(int expectedResult, String numbers) throws Exception{
        assertEquals(expectedResult,StringCalculator.add(numbers));
    }

    @DisplayName("Test the String calculator with the personalised delimiter")
    @ParameterizedTest
    @CsvSource({"10, '//;\n1\n2\n3;4'", "100,'//a\n10,10a10,10\n10,10,10,10,10,10'"})
    public void testAdditionWithPersonalisedDelimiter(int expectedResult, String numbers) throws Exception{
        assertEquals(expectedResult,StringCalculator.add(numbers));
    }

    @DisplayName("Test the String calculator with negative numbers")
    @ParameterizedTest
    @CsvSource({"Les nombres négatifs ne sont pas autorisés : -3, '//;\n1\n2\n-3;4'", "Les nombres négatifs ne sont pas autorisés : -1 -3 -4, '//;\n-1\n2\n-3;-4'"})
    public void testAdditionWithPersonalisedDelimiterAndNegativeNumbers(String expectedExceptionMessage, String numbers){
        try{
            StringCalculator.add(numbers);
            fail("didn't throw an exception !");
        } catch (Exception e){
            assertEquals(expectedExceptionMessage,e.getMessage());
        }
    }

    @DisplayName("Test the String calculator with numbers above one thousand")
    @ParameterizedTest
    @CsvSource({"10, '//;\n1\n2\n3;4;1001'"})
    public void testAdditionWithNumbersAboveOneThousand(int expectedResult, String numbers) throws Exception{
        assertEquals(expectedResult, StringCalculator.add(numbers));
    }
}
