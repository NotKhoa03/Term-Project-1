import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuHelp;
    JMenuItem iOpen, iNew, iSaveAs, iQuit;
    String name = "cool";
    int birthyear = 0;
    int pava = 0;

    int i = 1;

    newTavunu tav = new newTavunu(this, name, birthyear, pava);
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
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command){
            case "Open": file.open(); break;
            case "New": {
                tav.enterDetails();

                name = tav.returnName();
                birthyear = tav.returnBirthYear();
                pava = tav.returnPava();
                

                file.newFile(i);

                i++;
            } break;
        }

    }
}
