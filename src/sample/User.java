package sample;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {

    private String name, username, password, email, fileName;
    private int age, phoneNumber;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public boolean isLogin(String fileName, String user, String pass) throws IOException {
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
                if(user.equals(split[0]) && pass.equals(split[1]))
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
