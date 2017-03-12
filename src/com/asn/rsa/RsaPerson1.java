package com.asn.rsa;

import com.asn.utils.ModPow;
import com.asn.utils.PrimeNumbersGenerator;
import com.asn.utils.PrimeNumbersPair;
import com.asn.utils.socketUtils.SocketServer;

import java.util.Arrays;

/**
 * Created by mayank on 12/3/17.
 */
public class RsaPerson1 {

    public static void main(String[] args) {

        int p, q, n, privateKey, publicKey;
        String plainText = "", cipherText[];
        SocketServer socketServer = new SocketServer();
        PrimeNumbersPair primeNumbersPair = PrimeNumbersGenerator.generateRandomPrimeNumbersPair(256);
        PublicKeyPairGenerator publicKeyPairGenerator = new PublicKeyPairGenerator();

        p = primeNumbersPair.getNum1();
        q = primeNumbersPair.getNum2();
        n = p * q;

        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);

        privateKey = publicKeyPairGenerator.generatePrivateKey(p, q);
        publicKey = publicKeyPairGenerator.generatePublicKey(p, q, privateKey);

        System.out.println("privateKey: " + privateKey);
        System.out.println("publicKey: " + publicKey);

        socketServer.sendData(publicKey);
        socketServer.sendData(n);


        cipherText = socketServer.getString().split(" ");
        System.out.println("cipherText: " + Arrays.toString(cipherText));
        for (String aCipherString : cipherText) {
            int cipherInt = Integer.parseInt(aCipherString);
            plainText += String.valueOf((char)ModPow.modPow(cipherInt, privateKey, n));
        }
        System.out.println("plainText: " + plainText);

        socketServer.closeSocket();
    }
}
