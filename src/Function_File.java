import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;
    String fileName;
    String fileAddress;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public Function_File(GUI gui){

        this.gui = gui;

    }

    public void newFile(int i){

        gui.textArea.setText("");
        gui.window.setTitle("Tavunu " + i);

    }

    public void open(){

        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

            gui.textArea.setText("");

            String line = null;

            while((line = br.readLine()) != null) {

                gui.textArea.append(line + "\n");

            }

            br.close();

        } catch(Exception e){

            System.out.println("File not found");

        }


    }

    public void saveAs(boolean saveAs){ // saveAs is used to check whether file has been loaded or if its a new one
        if(saveAs) {
            FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
            fd.setVisible(true);

            if (fd.getFile() != null) {
                fileName = fd.getFile();
                fileAddress = fd.getDirectory();
                gui.window.setTitle(fileName);
            }

            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                fw.close();
            } catch (Exception e) {
                System.out.println("??");
            }
        }
        else
            System.out.println("Tavunu is already loaded, create a new one.");
    }

    public void quit(){
        System.exit(0);
    }

    public void about(){
        JOptionPane.showMessageDialog(null, "Made by Khoa Tonthat", "A Notepad to store Tavunu information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void createFont(int fontSize){

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch (selectedFont){
            case "Arial":{
                gui.textArea.setFont(arial);
                break;
            }
            case "Comic Sans MS":{
                gui.textArea.setFont(comicSansMS);
                break;
            }
            case "Times New Roman":{
                gui.textArea.setFont(timesNewRoman);
                break;
            }


        }
    }




}
