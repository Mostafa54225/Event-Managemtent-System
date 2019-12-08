package Request;

import Customer.RegisterController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import sample.User;

import java.io.*;

public class RequestCustomer extends User {

    // the name of file "Register Guests"
    private String filenameGuests = "Files/RegisterGuests.txt";


    // Override Methods from User Class to set The File
    @Override
    public void setFileName(String fileName) {
        this.filenameGuests = fileName;
    }

    @Override
    public String getFileName() {
        return filenameGuests;
    }


    // Method for add customer (Username, Email) and set This Information to File (RegisterGuests)
    public void addGuest(String filename, String name, String email, RadioButton r) throws IOException {


        BufferedWriter bufferedWriter = null;
        File file = new File(filenameGuests);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            if(file.length() == 0){
                bufferedWriter.write("1" + "#" + name + "#" + email + "#" + r.getText() + "\n");
            } else {
                int id = reId() + 1;
                bufferedWriter.write(id + "#" + name + "#" + email + "#" + r.getText() + "\n");
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
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
