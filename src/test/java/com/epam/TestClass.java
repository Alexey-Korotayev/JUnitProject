package com.epam;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    private ClassForTest testClass;


    @BeforeEach
    public void setUp() throws Exception {
        testClass = new ClassForTest();
        System.out.println("BeforeEach");
    }

    @BeforeAll
    public static void setUpAll() throws Exception {
        System.out.println("BeforeAll Start all tests");
    }

    @Test
    public void testConcatenateWords_AssertEquals() throws Exception {
        String str1 = "Строка 1";
        String str2 = "Строка 2";
        String rezult = testClass.concatenateWords(str1,str2);
        assertEquals(rezult,str1+" "+str2);
    }

    @Test
    public void testComputeFactorial_throws() throws Exception {
        int val = 5;
        long rezult = 120;
        long rezult2 = testClass.computeFactorial(val);
        assertEquals(rezult2,rezult);
    }

    @Test
    public void shouldFailBecauseTimeout() throws Exception {
        Random random = new Random();
        int val = random.nextInt(5)+10;
        System.out.println("Факториал "+val );
        Assertions.assertTimeout(Duration.ofMillis(10),
                () -> {
                    testClass.computeFactorial2(val);
                    return "result";
                }, "so long..." );
    }

    @Test
    public void testExpectedException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testClass.computeFactorial(-5);
        });
    }

    @Test
    public void testExpectedException2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testClass.computeFactorial2(-5);
        });
    }

    @Test
    @Disabled
    public void testNormalizeWord() {
        testClass.normalizeWord("test");
    }

    @AfterEach
    public void endEachp(){
        System.out.println("End the test");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("End all tests");
    }


}
