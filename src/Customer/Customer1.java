/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import static Customer.RegisterController.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import sample.User;

public class Customer1 extends User {
    private final String filenameGuests = "Files/RegisterGuests.txt";
    private final String name = nameInput.getText();
    private final String email = emailInput.getText();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String getFileName() {
        return filenameGuests;
    }
    
    public void addGuest(String filename, String name, String email, RadioButton r) throws IOException {


        BufferedWriter bufferedWriter = null;
        File file = new File(filenameGuests);
        setPassword(PasswordGenerator.generatePassword(8));
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            if(file.length() == 0){
                setId(1);
                bufferedWriter.write(getId() + "#" + getPassword() + "#" + name + "#" + email + "#" + r.getText() + "\n");
            } else {
                setId(reId() + 1);
                bufferedWriter.write(getId() + "#" + getPassword() + "#" + name + "#" + email + "#" + r.getText() + "\n");
            }



        } catch (Exception e) { 
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
        //MailSender.sendMail(getEmail(),"Dear "+ getName() + ", \n"+ "Your ID is : "+ getId() + " and your password is : " + getPassword());
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
    
    public boolean isLogin(String fileName, String id, String pass) throws IOException {
        boolean flag = false;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (Exception e){
            e.printStackTrace();
        }
        if(br != null){
            String string;
            while ((string = br.readLine()) != null){
                String[] split = string.split("#");
                if(id.equals(split[0]) && pass.equals(split[1]))
                    flag = true;
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Check Your Username and Password then try again!");
                    alert.showAndWait();
                }
            }
        }
        return flag;
    }
    
}

