package sample;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {

    private String username, password, fileName;
    private int phoneNumber;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
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
