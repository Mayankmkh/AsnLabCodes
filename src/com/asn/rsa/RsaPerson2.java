package com.asn.rsa;

import com.asn.utils.ModPow;
import com.asn.utils.socketUtils.SocketClient;

import java.util.Scanner;

/**
 * Created by mayank on 12/3/17.
 */
public class RsaPerson2 {

    public static void main(String[] args) {

        int otherPersonPublicKey, otherPersonN;
        String plainText, cipherText = "";
        SocketClient socketClient = new SocketClient();
        Scanner scanner = new Scanner(System.in);

        otherPersonPublicKey = socketClient.getInt();
        otherPersonN = socketClient.getInt();
        System.out.println("publicKey: " + otherPersonPublicKey);
        System.out.println("n: " + otherPersonN);

        System.out.print("Enter text to send: ");
        plainText = scanner.nextLine();
        for (int i = 0; i < plainText.length(); i++) {
            int plainTextInt = (int)plainText.charAt(i);
            cipherText += ModPow.modPow(plainTextInt, otherPersonPublicKey, otherPersonN) + " ";
        }
        System.out.println("cipherText: " + cipherText);

        socketClient.sendData(cipherText);

        socketClient.closeSocket();
    }

}
