import java.util.*;
import java.lang.*;

public class Tribe {
    public static void main(String[] args){

        int choice = 0;
        String name = "ddd";
        int birthyear = 0;
        int pava = 0;

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

                    System.out.println(name + " " + birthyear + " " + pava);
                    break;
                }

                case 2: {
                    System.out.println("Enter which member you want to remove:");
                    break;
                }
                case 3:

                case 4: {
                    System.out.println("Saved to file.");
                    break;
                }
                case 5: {
                    System.out.println("There are some tribe members in memory, do you want to continue and lose the data?");
                    break;
                }
                case 6:
            }
        }
    }
}
