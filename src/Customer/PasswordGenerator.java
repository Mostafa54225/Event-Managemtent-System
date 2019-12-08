/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.util.Random;

/**
 *
 * @author Khalifa
 */
public class PasswordGenerator {
    public static String generatePassword(int length) {
        String Characters ="AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        char[] temp = new char[length];
        String password="";
        Random rand = new Random();
        for (int i=0;i<length;i++) {
            temp[i] = Characters.charAt(rand.nextInt(Characters.length()));
        }
        for(int i=0;i<temp.length;i++) {
            password+=temp[i];
        }
        return password;
    }
}
