package com.epam;

public class App {


    public static void main(String[] args) {

        System.out.println( "JUnit 5" );

        ClassForTest testClass = new ClassForTest();

        System.out.println(testClass.concatenateWords("11111","2222"));
        System.out.println(testClass.concatenateWords("11111",null));
        System.out.println(testClass.concatenateWords(null,"2222"));

        Caclulator calc = new Caclulator();

        System.out.println(calc.calcFibonacci(3));
        System.out.println(calc.calcFibonacci(5));
        System.out.println(calc.calcFibonacci(10));
        System.out.println(calc.calcFibonacci(50));
    }


}
