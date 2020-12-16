import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuHelp;
    JMenuItem iOpen, iNew, iSaveAs, iQuit, iAbout;
    boolean saveAs = false;
    String name = "cool";
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
