/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author DELL
 */
public class Cypher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*,.";

    // create encryptData() method for encrypting user input string with given shift key   
    public static String encryptData(String inputStr, int shiftKey) {
        // encryptStr to store encrypted data   
        String encryptStr = "";

        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++) {
            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));

            // get encrypted char for each char of inputStr   
            int encryptPos = (shiftKey + pos) % 72;
            char encryptChar = ALPHABET.charAt(encryptPos);

            // add encrypted char to encrypted string   
            encryptStr += encryptChar;
        }

        // return encrypted string   
        return encryptStr;
    }

    // create decryptData() method for decrypting user input string with given shift key   
    public static String decryptData(String inputStr, int shiftKey) {

        // decryptStr to store decrypted data   
        String decryptStr = "";

        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++) {

            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));

            // get decrypted char for each char of inputStr   
            int decryptPos = (pos - shiftKey) % 72;

            // if decryptPos is negative   
            if (decryptPos < 0) {
                decryptPos = ALPHABET.length() + decryptPos;
            }
            char decryptChar = ALPHABET.charAt(decryptPos);

            // add decrypted char to decrypted string   
            decryptStr += decryptChar;
        }
        // return decrypted string   
        return decryptStr;
    }

    public static String generateData() {
        String data = "";
        for (int i = 0; i <= 20; i++) {
            int index = (int) (Math.random() * ALPHABET.length());
            data += ALPHABET.charAt(index);
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(generateData());
    }
}
