/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenaencriptada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class MessageDigestExample {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la contraseña para cifrar");
        String message = sc.nextLine();
        String encriptado;
	   
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(message.getBytes());
      
        byte[] digest = md.digest();      
        System.out.println(digest);  
        encriptado = new String(digest, java.nio.charset.StandardCharsets.UTF_8);
        
        
      
        try{
            File contraseña = new File("contraseña.txt");
            BufferedWriter escribir = new BufferedWriter(new FileWriter(contraseña));
            
            
            StringBuffer hexString = new StringBuffer();
      
      for (int i = 0;i<digest.length;i++) {
         hexString.append(Integer.toHexString(0xFF & digest[i]));
         escribir.write(hexString.toString());
      }
      escribir.close();
      muestraContenido("contraseña.txt");
    }catch(Exception e){
            System.out.println("Error al escribir");
        }
         compararContenido();
    }
    
        public static void muestraContenido(String archivo) throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine()) !=null ){
            System.out.println(cadena);
        }
        b.close();
    }
        
       public static void compararContenido() throws FileNotFoundException{
           String texto= "";
           Scanner leer = new Scanner(System.in);
           System.out.println("Introduce la contraseña cifrada: ");
           texto  = leer.nextLine();
           try{
               FileReader fr = new FileReader("contraseña.txt");
               BufferedReader bf = new BufferedReader(fr);
               String st;
                while ((st = bf.readLine()) != null){             
                if (texto.equals(st)) {
                    System.out.println("La contraseña es correcta");
                } else {
                    System.out.println("La contraseña es incorrecta");
                  }
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
           }
      }
    


