import java.util.Scanner;

public class newTavunu {

    GUI gui;
    String name = "";
    int birthyear = 0;
    int pava = 0;
    Tavunu tavunu;

    Scanner sc = new Scanner(System.in);

    public newTavunu(GUI gui, String name, int birthyear, int pava)
    {
        this.gui = gui;
        this.name = name;
        this.pava = pava;
        this.birthyear = birthyear;

    }

    public void enterDetails()
    {
        System.out.println("Enter name of tavuna:");
        name = sc.next();
        sc.nextLine(); //Takes the enter input

        System.out.println("Enter birthyear:");
        birthyear = sc.nextInt();

        System.out.println("Enter amount of pava:");
        pava = sc.nextInt();

        if(pava < 10)
        {
            pava = 10;
        }
    }



    public Tavunu returnTavunu()
    {
        return tavunu;
    }

    public String returnName()
    {
        return name;
    }

    public int returnBirthYear()
    {
        return birthyear;
    }

    public int returnPava()
    {
        return pava;
    }


}
