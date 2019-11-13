package foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FooBarQixTest {
    FooBar fooBar = new FooBar();

    // test d'exception inférieur ou égal à zéro
    @ParameterizedTest
    @ValueSource(ints ={-1,-2,-400})
    void should_refuse_negative_numbers(int input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> fooBar.fooBarQix(input));
    }

    // tests de fooBar divisible
    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    void should_return_self_by_default(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals(""+input, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    void div_should_return_self_by_default(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals(""+input, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void modulo_3_not_5_should_return_foo(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals("Foo", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,25})
    void modulo_5_not_3_should_return_bar(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals("Bar",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={15,30,45})
    void modulo_3_and_5_should_return_foobar(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals("FooBar",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={7,49,14})
    void modulo_7_not_3_not_5_should_return_qix(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals("Qix",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={21})
    void modulo_7_3_should_return_fooqix(int input) {
        String result = fooBar.divisible(input);
        Assertions.assertEquals("FooQix",result);
    }

    // tests de fooBar concat
    @ParameterizedTest
    @ValueSource(ints ={1,2,4})
    void concat_default_return_empty_string (int input){
        String result = fooBar.concat(input);
        Assertions.assertEquals("",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={3,31,13})
    void concat_contains_3_return_foo_string (int input){
        String result = fooBar.concat(input);
        Assertions.assertEquals("Foo",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={5,51,15})
    void concat_contains_5_return_bar_string (int input){
        String result = fooBar.concat(input);
        Assertions.assertEquals("Bar",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={7,71,17})
    void concat_contains_7_return_bar_string (int input){
        String result = fooBar.concat(input);
        Assertions.assertEquals("Qix",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={357,325471,305017})
    void concat_contains_357_return_bar_string (int input){
        String result = fooBar.concat(input);
        Assertions.assertEquals("FooBarQix",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={333,323431,303013})
    void concat_contains_333_return_bar_string (int input){
        String result = fooBar.concat(input);
        Assertions.assertEquals("FooFooFoo",result);
    }
    // integration des 2 méthodes
    @ParameterizedTest
    @ValueSource(ints ={1,2,4})
    void foobarqix_default_return_string_input (int input){
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals(""+input,result);
    }

    @ParameterizedTest
    @ValueSource(ints ={357})
    void setFooBar_contains_div_3_div_7_357_return_bar_string (int input){
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("FooQixFooBarQix",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={31, 34,13})
    void setFooBar_contains_3_return_input_foos_tring (int input){
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals(input+"Foo",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={105})
    void setFooBar_contains_5_div357_return_input_foobarqixbar_string (int input){
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("FooBarQixBar",result);
    }
}
