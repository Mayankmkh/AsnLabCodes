package com.asn;

import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainText, cipherText = "";
        int key;
        System.out.println("Plain text: ");
        plainText = scanner.nextLine();
        System.out.println("Key: ");
        key = scanner.nextInt();

        cipherText = encryptText(plainText, key);
        System.out.println("Cipher text: " + cipherText);
        System.out.println("Plain text: " + decryptText(cipherText, key));
    }

    private static String encryptText(String plainText, int key) {
        key %= 26;
        String cipherText = "";
        int plainTextLength = plainText.length();

        for (int i = 0; i < plainTextLength; i++) {
            char c = plainText.charAt(i);
            int baseAscii = Character.isUpperCase(c) ? 65 : 97;
            int newAscii = ((int)c % baseAscii + key) % 26 + baseAscii;
            char newChar = ((char) newAscii);
            cipherText += newChar;
        }
        return cipherText;
    }

    private static String decryptText(String cipherText, int key) {
        key %= 26;
        String plainText = "";
        int cipherTextLength = cipherText.length();

        for (int i = 0; i < cipherTextLength; i++) {
            char c = cipherText.charAt(i);
            int baseAscii = Character.isUpperCase(c) ? 65 : 97;
            int newAscii = ((int)c % baseAscii + 26 - key) % 26 + baseAscii;
            char newChar = ((char) newAscii);
            plainText += newChar;
        }
        return plainText;
    }
}
