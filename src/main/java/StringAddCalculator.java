import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static void main(String[] args) {
        splitAndSum("1,2");
    }

    public static int splitAndSum(String input) {
        if(input == null || input.equals("")) return 0;

        if(input.length() == 1) return 1;

        int sum = 0;

        if(input.contains("-")) {
            throw new RuntimeException("runtime exception");
        }

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] items= m.group(2).split(customDelimiter);
            // 덧셈 구현

            for(String item : items) {
                sum += Integer.parseInt(item);
            }
        }

        if(input.contains(":")) {
            String[] items = input.split("[:,]");

            for(String item : items) {
                sum += Integer.parseInt(item);
            }
        }
        else if(input.contains(",")) {
            String[] items = input.split(",");

            for(String item : items) {
                sum += Integer.parseInt(item);
            }
        }

        return sum;
    }
}
