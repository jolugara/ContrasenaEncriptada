/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenaencriptada;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author alumno
 */
public class keyPairyYkeyPairGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize (1024);
        KeyPair par = keyGen.generateKeyPair();
        PrivateKey clavepriv = par.getPrivate();
        PublicKey clavepub = par.getPublic();
 
 
        Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c.init(Cipher.ENCRYPT_MODE, clavepub);
 
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la contraseña:");
        String contraseña = sc.nextLine();
        byte textoPlano[] = contraseña.getBytes();
        byte textoCifrado[] = c.doFinal(textoPlano);
            System.out.println("Contraseña: " + contraseña);
        System.out.println("Encriptado: "+ new String(textoCifrado));
  
        c.init(Cipher.DECRYPT_MODE, clavepriv); 
        byte desencriptado[] = c.doFinal(textoCifrado);
        System.out.println("Desencriptado: "+ new String(desencriptado));
 
 } catch (Exception e) {
 e.printStackTrace();
 }
    }
    
}
