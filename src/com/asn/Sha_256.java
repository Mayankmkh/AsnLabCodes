package com.asn;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by mayank on 15/3/17.
 */
public class Sha_256 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String message, digestString = "";

            System.out.print("Message: ");
            message = scanner.nextLine();

            byte[] digestBytes = messageDigest.digest(message.getBytes());

            for (byte digestByte : digestBytes) {
                digestString += String.format("%02x", digestByte);
            }

            System.out.println("SHA-256: " + digestString);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
