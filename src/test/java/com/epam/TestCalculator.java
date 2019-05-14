package com.epam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestCalculator {

    @Test
    public void iterator_will_return_hello_world() {
        System.out.println("Start Mockito");
        //подготавливаем
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        //выполняем
        String result = i.next() + " " + i.next();
        //сравниваем
        assertEquals("Hello World", result);
    }

    private Caclulator calc;

    @BeforeEach
    public void setBeforeTest() {
        calc = new Caclulator();
    }

    @ParameterizedTest
    @CsvSource({ "1, 1, 2", "1, 2, 3", "0, 0, 1" })
    void testSumTwoNumbers(int x, int y, int res) {
        System.out.println("! x+y= "+x+"+"+y+"="+res );
        assertEquals(res, calc.sumTwoNumbers(x,y));
    }

    @ParameterizedTest
    @CsvSource({ "1, 1, 0", "1, 2, -1", "5, -2, 7" })
    void testNumberMinusNumber(int x, int y, int res) {
        System.out.println("! x-y= "+x+"-"+y+"="+res );
        assertEquals(res, calc.numberMinusNumber(x,y));
    }


    @CsvSource({ "1, 1, 1", "10, 0, 0", "-5, -2, 10" })
    void testMultiplication(int x, int y, int res) {
        System.out.println("! x*y= "+x+"-"+y+"="+res );
        assertEquals(res, calc.multiplication(x,y));
    }

    @Test
    public void testExpectedException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.numberDivideNumber(10,0);
        });
    }

    @Test
    public void testRoundDivide() {
        System.out.println("round x/y= " );
        double result = calc.numberDivideNumber(10,3);
        assertEquals(10/3, result,0.00001);
    }

    @ParameterizedTest
    @CsvSource({"1","50" })
    public void testCalcFibonacciTimeout(int n) throws Exception {
        System.out.println("Фибоначи для " + n );
        Assertions.assertTimeout(Duration.ofMillis(2),
                () -> {
                    calc.calcFibonacci(n);
                    return "result";
                }, "so long..." );
    }


}
