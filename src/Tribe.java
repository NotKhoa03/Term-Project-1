import java.util.*;
import java.lang.*;
import java.io.*;

public class Tribe {
    public static void main(String[] args){

        int choice = 0;
        int remove = 0;
        String name = "ddd";
        int birthyear = 0;
        int pava = 0;
        PrintWriter file = null;
        ArrayList<String> list = new ArrayList<>();

        while(choice != 6) {
            System.out.println("Choose from the following:");

            System.out.println("1. Add a member \n2. Remove a member \n3. Display the tribe \n4. Save the tribe \n5. Open the tribe \n6. Quit");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter name of tavuna:");
                    name = sc.next();
                    sc.nextLine();

                    System.out.println("Enter birthyear:");
                    birthyear = sc.nextInt();

                    System.out.println("Enter amount of pava:");
                    pava = sc.nextInt();

                    if(isCrode(birthyear, pava))
                    {
                        list.add(name + " born in " + birthyear + " is a Crode with " + pava + " pava.");
                    }
                    else if(isCrodeExalted(birthyear, pava))
                    {
                        list.add(name + " born in " + birthyear + " is an Exalted Crode with " + pava + " pava.");
                    }
                    else if(isAvo(pava))
                    {
                        list.add(name + " born in " + birthyear + " is an Avo with " + pava + " pava.");
                    }
                    else if(isBeele(pava))
                    {
                        list.add(name + " born in " + birthyear + " is a Beele with " + pava + " pava.");
                    }

                    break;
                }

                case 2: {
                    System.out.println("Enter the number of which member you want to remove:");
                    displayNumberedArrayList(list);
                    remove = sc.nextInt();
                    list.remove(remove-1);
                    break;
                }
                case 3:
                    displayArrayList(list);
                    break;

                case 4: {
                    try{
                        new PrintWriter("File.txt");
                        for (int i = 0; i < list.size(); i++)
                        {
                            file.println(list.get(i));
                        }

                        file.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Exception?? how??");
                    }

                    System.out.println("Saved to file.");
                    break;
                }
                case 5: {
                    /*System.out.println("There are some tribe members in memory, do you want to continue and lose the data?");
                    char answer;
                    try
                    {
                        Scanner fileInput = new Scanner(new File("File.txt"));
                        while(fileInput.hasNextLine())
                        {
                            for (int k = 0; k < list.size(); k++)
                            {
                                list.add(k, fileInput.nextLine());
                            }
                        }
                    }
                    catch(Exception e) {
                        return;
                    }
                    //Scanner scan = new Scanner(fileInput);
*/
                    break;
                }
                case 6:
            }
        }
    }

    public static boolean isCrode(int birthYear, int pava)
    {
        if(pava <= 80)
        {
            return false;
        }

        if(birthYear%2 == 0)
        {
            return false;
        }

        else
            return true;
    }

    public static boolean isCrodeExalted(int birthYear, int pava)
    {
        if(birthYear%2 == 1)
        {
            return false;
        }

        if(pava <= 80)
        {
            return false;
        }
        else
            return true;
    }

    public static boolean isAvo(int pava)
    {
        if(pava > 20)
        {
            return false;
        }
        else
            return true;
    }

    public static boolean isBeele(int pava)
    {
        if(pava < 21 || pava > 80)
        {
            return false;
        }
        else
            return true;
    }

    public static void displayNumberedArrayList(ArrayList<String> tobedisp){
        for (int i  = 0; i < tobedisp.size(); i++)
        {
            System.out.println(i+1 + ". " + tobedisp.get(i));
        }
    }

    public static void displayArrayList(ArrayList<String> tobedisp){
        for (int i = 0; i < tobedisp.size(); i++)
        {
            System.out.println(tobedisp.get(i));
        }
    }


}
