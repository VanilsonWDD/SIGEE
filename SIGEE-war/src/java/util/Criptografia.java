/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Vanilson
 */
public class Criptografia {
    public static String encriptar(String senha){  
        String senhaEncriptada = "";
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            System.out.println("Erro ao encriptar a senha: " + e.getMessage());  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        senhaEncriptada = hash.toString(16);              
        return senhaEncriptada;  
    }    
}
