package com.asn.rsa;

import com.asn.utils.ModPow;

/**
 * Created by mayank on 12/3/17.
 */
public class PublicKeyPairGenerator {


    //private key should not be a factor of (p-1) and (q-1)
    int generatePrivateKey(int p, int q) {
        --p;
        --q;
        int privateKey = 0;
        while(true) {
            ++privateKey;
            if (((p % privateKey) != 0) && ((q % privateKey) != 0)) break;
        }
        return privateKey;
    }

    //formula: (publicKey*privateKey)mod(p-1)*(q-1) = 1
    int generatePublicKey(int p, int q, int privateKey) {
        int publicKey = 0, n = --p * --q;
        while (true) {
            ++publicKey;
            if (ModPow.mutliplicativeMod(publicKey, privateKey, n) == 1) break;
        }
        return publicKey;
    }
}
