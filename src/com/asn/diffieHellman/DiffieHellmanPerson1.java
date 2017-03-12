package com.asn.diffieHellman;

import com.asn.utils.ModPow;
import com.asn.utils.PrimeNumbersGenerator;
import com.asn.utils.PrimeNumbersPair;
import com.asn.utils.socketUtils.SocketServer;

/**
 * Created by mayank on 9/3/17.
 */
public class DiffieHellmanPerson1 {

    public static void main(String[] args) {

        SocketServer socketServer = new SocketServer();
        PrimeNumbersPair primeNumbersPair = PrimeNumbersGenerator.generateRandomPrimeNumbersPair();
        int n, g, x, a, b, key;
        socketServer.sendData(n = primeNumbersPair.getNum1());
        socketServer.sendData(g = primeNumbersPair.getNum2());

        x = PrimeNumbersGenerator.generatePrimeNumber(g - 1);

        a = ModPow.modPow(g, x, n);
        socketServer.sendData(a);
        b = socketServer.getInt();
        key = ModPow.modPow(b, x, n);
        System.out.println(key);
        socketServer.closeSocket();
    }
}
