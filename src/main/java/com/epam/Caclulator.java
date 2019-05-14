package com.epam;

import java.time.Duration;

public class Caclulator {

    public long sumTwoNumbers(int x, int y) {
        return x+y;
    }

    public long calcFibonacci(int n) {
        if ( n ==1 || n == 0)
            return n;
        long first = 0;
        long second = 1;
        long temp = 1;
        for (int i = 1; i<n; i++) {
            temp = second;
            try {
                Math.addExact(second, first);
                second = second + first;
            } catch (ArithmeticException e) {
                throw e;
            }
            first = temp;
            for (int j = 1; j <= 1000000000; j++) {
                temp = (j+j)/2-j;
            }
        }
        return second;
    }

    public long multiplication(int x, int y) {
        return x*y;
    }

    public int numberMinusNumber(int x, int y) {
        return x-y;
    }

    public double numberDivideNumber(int x, int y) {
        double res;
        if ( y == 0 )
            throw new IllegalArgumentException();
        res = x/1.0d/y;
        return res;
    }

}
