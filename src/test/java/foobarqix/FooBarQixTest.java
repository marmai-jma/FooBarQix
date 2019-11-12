package foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FooBarQixTest {
    FooBar fooBar = new FooBar();

    @ParameterizedTest
    @ValueSource(ints ={-1,-2,-400})
    void should_refuse_negative_numbers(int input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> fooBar.fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    void should_return_self_by_default(int input) {
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals(""+input, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void modulo_3_not_5_should_return_foo(int input) {
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("Foo", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,25})
    void modulo_5_not_3_should_return_bar(int input) {
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("Bar",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={15,30,45})
    void modulo_3_and_5_should_return_foobar(int input) {
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("FooBar",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={7,49,14})
    void modulo_7_not_3_not_5_should_return_qix(int input) {
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("Qix",result);
    }

    @ParameterizedTest
    @ValueSource(ints ={21})
    void modulo_7_3_should_return_fooqix(int input) {
        String result = fooBar.fooBarQix(input);
        Assertions.assertEquals("FooQix",result);
    }
}
