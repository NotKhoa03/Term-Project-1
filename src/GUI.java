import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuHelp, menuFormat, fontSize, font;
    JMenuItem iOpen, iNew, iSaveAs, iQuit, iAbout, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20;

    boolean saveAs = false;
    String name = "";
    int birthyear = 0;
    int pava = 0;
    boolean isTrue = true;

    int i = 1;

    newTavunu tav = new newTavunu(this, name, birthyear, pava);
    Tavunu tavo;
    Function_File file = new Function_File(this);

    public static void main(String[] args){

        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();

        file.selectedFont = "Arial";
        file.createFont(16);

        window.setVisible(true);

    }

    public void createWindow(){
        window = new JFrame("Test");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){
        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }

    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);


    }

    public void createFileMenu()
    {
        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iQuit = new JMenuItem("Quit");
        iQuit.addActionListener(this);
        iQuit.setActionCommand("Quit");
        menuFile.add(iQuit);

        iAbout = new JMenuItem("About");
        iAbout.addActionListener(this);
        iAbout.setActionCommand("About");
        menuHelp.add(iAbout);

        fontSize = new JMenu("Font Size");
        menuFormat.add(fontSize);

        font = new JMenu("Font");
        menuFormat.add(font);

        iFontSize8 = new JMenuItem("Font Size: 8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("FontSize8");
        fontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("Font Size: 12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("FontSize12");
        fontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("Font Size: 16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("FontSize16");
        fontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("Font Size: 20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("FontSize20");
        fontSize.add(iFontSize20);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        font.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        font.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        font.add(iFontTNR);


    }




    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command){
            case "Open": {
                file.open();
                saveAs = false;
                textArea.setEditable(false);
            } break;
            case "New": {


                while(isTrue){
                    tav.enterDetails();
                    name = tav.returnName();
                    birthyear = tav.returnBirthYear();
                    pava = tav.returnPava();

                    if (name.charAt(0) == 'T' || name.charAt(0) == 'D') {
                        isTrue = false;
                        break;
                    }
                    System.out.println("Enter a valid name");
                }



                checkTribe(birthyear, pava);


                //System.out.print(tavo.toString());

                file.newFile(i);

                textArea.setText(tavo.toString());
                textArea.setEditable(false);

                saveAs = true;

                i++;
            } break;
            case "Save As": {
                file.saveAs(saveAs);
            } break;
            case "Quit":{
                file.quit();
            } break;
            case "About": {
                file.about();
            } break;

            case "Arial":{
                file.setFont(command);
            }break;
            case "Comic Sans MS":{
                file.setFont(command);
            }break;
            case "Times New Roman":{
                file.setFont(command);
            }break;

            case "FontSize8": {
                file.createFont(8);
            } break;

            case "FontSize12": {
                file.createFont(12);
            } break;

            case "FontSize16": {
                file.createFont(16);
            } break;

            case "FontSize20": {
                file.createFont(20);
            } break;
        }

    }

    public void checkTribe(int birthYear, int pava){

        if(pava > 80 && birthYear%2 == 1)
        {
            tavo = new Crode(name, birthyear, pava);
        }

        else if(birthYear%2 == 0 && pava > 80)
        {
            tavo = new CrodeExalted(name, birthyear, pava);
        }

        else if(pava <= 20)
        {
            tavo = new Avo(name, birthyear, pava);
        }

        else if(pava >= 21 || pava <= 80)
        {
            tavo = new Beele(name, birthyear, pava);
        }
    }




}
