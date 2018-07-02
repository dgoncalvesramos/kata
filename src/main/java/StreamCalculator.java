import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamCalculator {
    private static final String regexPersonalisedDelimiter = "\\/\\/.\n";
    private static final String regexDelimiter = ",|\n";

    static int add(String numbers) throws Exception {
        int res = 0;

        if(numbers.equals(""))
            return 0;

        String regexDelimiter = numbers.substring(0,4);
        String personalisedDelimiter = buildPersonalisedDelimiter(regexDelimiter);

        if(personalisedDelimiter == null) {
            verifyNegativeNumbers(numbers,null);
            res = Arrays.stream(numbers.split(StreamCalculator.regexDelimiter))
                    .mapToInt(Integer::valueOf)
                    .filter(i -> i < 1000)
                    .sum();
        }
        else {
            verifyNegativeNumbers(numbers.substring(4),personalisedDelimiter);
            res = Arrays.stream(numbers.substring(4).split(StreamCalculator.regexDelimiter + "|" + personalisedDelimiter))
                    .mapToInt(Integer::valueOf)
                    .filter(i -> i < 1000)
                    .sum();
        }

        return res;

    }

    private static void verifyNegativeNumbers(String numbers, String personalisedDelimiter) throws Exception {
        String exceptionMsg = Arrays.stream(numbers.split(StreamCalculator.regexDelimiter + "|" + personalisedDelimiter))
                .mapToInt(Integer::valueOf)
                .filter(i-> i < 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        if(!exceptionMsg.equals(""))
            throw new Exception("Les nombres négatifs ne sont pas autorisés : " + exceptionMsg);
    }

    private static String buildPersonalisedDelimiter(String regexDelimiter){
        return regexDelimiter.matches(StreamCalculator.regexPersonalisedDelimiter) ?
                String.valueOf(regexDelimiter.charAt(regexDelimiter.length()-2)) : null;
    }

}
