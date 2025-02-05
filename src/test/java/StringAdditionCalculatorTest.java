import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdditionCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAdditionCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAdditionCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void inputOneNumber() {
        String items = "1";
        int result = StringAdditionCalculator.splitAndSum(items);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void inputTwoNumbersSplitComma() {
        String items = "1,2";
        int result = StringAdditionCalculator.splitAndSum(items);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitCommaAndColon() {
        String items = "1,2:3";
        int result = StringAdditionCalculator.splitAndSum(items);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void customSeparator() {
        String items = "//;\n1;2;3;";
        int result = StringAdditionCalculator.splitAndSum(items);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void detectNegativeNumberAndRunTimeException() {
        String items = "-1,2,3";

        assertThatThrownBy(() -> StringAdditionCalculator.splitAndSum(items))
        .isInstanceOf(RuntimeException.class);
    }
}
