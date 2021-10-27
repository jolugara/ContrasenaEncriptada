/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenaencriptada;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.*;    
import java.security.*;  
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class KeyGeneratorExample {

    /**
     * @param args the command line arguments
     */
     private static SecretKey key = null;         
 private static Cipher cipher = null; 
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
       
         KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
         keyGenerator.init(128);
         SecretKey secretKey = keyGenerator.generateKey();
         System.out.println("Clave Secreta: " +secretKey );
         cipher = Cipher.getInstance("AES");
 
         Scanner sc = new Scanner(System.in);
         System.out.println("Introduce la contraseña:");
         String contraseña = sc.nextLine();
         byte[] clearTextBytes = contraseña.getBytes("UTF8");
         System.out.println("Contraseña: " + contraseña);
 
         cipher.init(Cipher.ENCRYPT_MODE, secretKey);
         byte[] cipherBytes = cipher.doFinal(clearTextBytes);
         String cipherText = new String(cipherBytes, "UTF8");
         System.out.println("Texto cifrado: " + cipherText);
 
         cipher.init(Cipher.DECRYPT_MODE, secretKey);
         byte[] decryptedBytes = cipher.doFinal(cipherBytes);
         String decryptedText = new String(decryptedBytes, "UTF8");
         System.out.println("Texto descifrado: " + decryptedText);
    }
    
}
