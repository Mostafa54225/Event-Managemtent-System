package Request;

import Customer.EventRegisterController;
import sample.User;

import java.io.*;

public class RequestEvent extends User {
    // The Name Of File (File Events)
    private String fileEvent = "Files/FilesEvents.txt";

    // Override Methods from User Class To Set The File
    @Override
    public void setFileName(String fileName) {
        this.fileEvent = fileName;
    }
    @Override
    public String getFileName() {
        return fileEvent;
    }


    // Method For Add The Details about the event and set this details into File (FileEvents)
    public void addEvent(String filename){

        String result = "";
        boolean c = false;
        BufferedWriter bufferedWriter = null;
        File file = new File(filename);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            // For Get Value from Check Box
            if(EventRegisterController.breakfast.isSelected()){
                result += EventRegisterController.breakfast.getText() + " ";
                c = true;
            }
            if(EventRegisterController.lunch.isSelected()){
                result += EventRegisterController.lunch.getText() + " ";
                c = true;
            }
            if(EventRegisterController.dinner.isSelected()){
                result += EventRegisterController.dinner.getText() + " ";
                c = true;
            }
            if(!c)
                result = "No Food";


            if(file.length() == 0){
                // Add Records to The File
                bufferedWriter.write("1" + "#" + EventRegisterController.EnameInput.getText() + "#" +  EventRegisterController.EtypeCB.getValue() +"#"
                        + EventRegisterController.noOfPplInput.getText() + "#" + EventRegisterController.cityInput.getText() + "#"
                        + EventRegisterController.Edate.getValue() + "#" + result + "\n");
            } else {
                int id = retrieveId() + 1;
                bufferedWriter.write( id - 1 + "#" + EventRegisterController.EnameInput.getText() + "#" +  EventRegisterController.EtypeCB.getValue() +"#"
                        + EventRegisterController.noOfPplInput.getText() + "#" + EventRegisterController.cityInput.getText() + "#"
                        + EventRegisterController.Edate.getValue() + "#" + result + "\n");
            }


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // Method for get the last id entered into the file
    private static int retrieveId() throws IOException {
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
