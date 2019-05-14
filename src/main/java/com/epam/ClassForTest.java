package com.epam;

import java.nio.charset.StandardCharsets;

public class ClassForTest {

        public String concatenateWords(String str1, String str2) {
            return str1+" "+str2;
        }



    public long computeFactorial (int val)  {
            if (val < 0)
            throw new IllegalArgumentException();

            if (val == 0)
                return 0;

            int ret = 1;
            for (int i = 1; i <= val; ++i) ret *= i;
            return ret;
        }

    public void computeFactorial2 (int val) throws InterruptedException {
        if (val < 0)
            throw new RuntimeException();

        int ret = 1;
        for (int i = 1; i <= val; i++) {
            ret *= i;
            Thread.sleep(1);
        }
    }

    public void normalizeWord(String str) {
            System.out.println("Hello!");
    }

}
