package com.asn.diffieHellman;

import com.asn.utils.ModPow;
import com.asn.utils.PrimeNumbersGenerator;
import com.asn.utils.socketUtils.SocketClient;

/**
 * Created by mayank on 9/3/17.
 */
public class DiffieHellmanPerson2 {

    public static void main(String[] args) {

        SocketClient socketClient = new SocketClient();
        int n = socketClient.getInt();
        int g = socketClient.getInt();

        int y = PrimeNumbersGenerator.generatePrimeNumber(g - 1);

        int b = ModPow.modPow(g, y, n);
        socketClient.sendData(b);
        int a = socketClient.getInt();
        int key = ModPow.modPow(a, y, n);
        System.out.println(key);
        socketClient.closeSocket();
    }
}
