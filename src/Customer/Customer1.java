/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.RadioButton;
import sample.User;

public class Customer1 extends User {
    private String filenameGuests = "Files/RegisterGuests.txt";
    private String password;
    
    
    public String getFileName() {
        return filenameGuests;
    }
    
    public void addGuest(String filename, String name, String email, RadioButton r) throws IOException {


        BufferedWriter bufferedWriter = null;
        File file = new File(filenameGuests);
        password = PasswordGenerator.generatePassword(8);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            if(file.length() == 0){
                bufferedWriter.write("1" + "#" + password + "#" + name + "#" + email + "#" + r.getText() + "\n");
            } else {
                int id = reId() + 1;
                bufferedWriter.write(id + "#" + password + "#" + name + "#" + email + "#" + r.getText() + "\n");
            }



        } catch (Exception e) { ///////////////////////////ERROR///////////////////////////
            //e.printStackTrace();
            System.err.println("Error! 3");
        } finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("Error! 4");
            }
        }
    }

    // Method for get the last id entered into the file
    private static int reId() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Files/RegisterGuests.txt"));
        String str = null, temp;
        while ((temp = br.readLine()) != null)
            str = temp;
        String lastLine = str;
        assert lastLine != null;
        String[] s = lastLine.split("#");
        
        return Integer.parseInt(s[0]);
    }
}

