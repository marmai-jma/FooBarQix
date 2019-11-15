package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {
    @Test
    void should_return_0_if_empty() {
        String input = "";
        int result = StringCalculator.add(input);
        Assertions.assertEquals(0, result);
    }

    @Test
    void should_return_number_if_string_has_one_number(){
        String input="123";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(123,sum);
    }

    @Test
    void should_return_sum_of_2_numbers_if_string_has_number_comma_number(){
        String input = "123,1";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(124,sum);
    }

    @Test
    void should_return_sum_of_unknown_numbers_if_string_has_unknown_number_separated_by_commas(){
        String input = "123,1,2,0";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(123+1+2+0,sum);
    }

    @Test
    void should_find_a_delimiter(){
        String input = "//;;\n1";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(1,sum);
    }

    @Test
    void should_return_number_if_string_has_one_number_with_delimiter(){
        String input="//###\n123";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(123,sum);
    }

    @Test
    void should_return_sum_of_2_numbers_if_string_has_number_comma_number_with_delimiter(){
        String input = "//aa\n123aa1";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(124,sum);
    }

    @Test
    void should_return_sum_of_unknown_numbers_if_string_has_unknown_number_separated_by_commas_with_delimiter(){
        String input = "//##\n123,1##2,0";
        int sum = StringCalculator.add(input);
        Assertions.assertEquals(123+1+2+0,sum);
    }
    @Test
    void should_return_exception_if_string_has_negative_number(){
        String input = "-1";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.add(input));
    }

    @Test
    void should_return_exception_with_list_if_string_has_multiple_negative_number(){
        String input = "-1,-2";
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> StringCalculator.add(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("-1")
        .hasMessageContaining("-2");
    }
}
