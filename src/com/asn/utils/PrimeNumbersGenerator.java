package com.asn.utils;

import java.util.Random;

/**
 * Created by mayank on 9/3/17.
 */
public class PrimeNumbersGenerator {

    public static PrimeNumbersPair generateRandomPrimeNumbersPair() {
        return generateRandomPrimeNumbersPair(Short.MAX_VALUE);
    }

    public static PrimeNumbersPair generateRandomPrimeNumbersPair(int max) {
        int num1, num2;
        num1 = generatePrimeNumber(max);
        num2 = generatePrimeNumber(num1 - 1);
        return new PrimeNumbersPair(num1, num2);
    }

    public static int generatePrimeNumber(int max) {
        Random random = new Random();
        int randomNum;
        while (true) {
            randomNum = random.nextInt(max);
            if (randomNum > 32 && isPrime(randomNum)) break;
        }
        return randomNum;
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for(int i = 3; i*i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
