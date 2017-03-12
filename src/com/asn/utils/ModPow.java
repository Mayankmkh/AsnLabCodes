package com.asn.utils;

/**
 * Created by mayank on 9/3/17.
 */
public class ModPow {

    public static int modPow(int base, int power, int mod) {

        base %= mod;

        int ans = 1;
        for (int i = 0; i < power; i++) {
            ans = (ans * base) % mod;
        }

        return ans;
    }

    // (a*b)%c = ((a%c)*(b%c))%c
    public static int mutliplicativeMod(int num1, int num2, int mod) {
        return ((num1 % mod) * (num2 % mod)) % mod;
    }

}
