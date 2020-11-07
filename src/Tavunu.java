
/**
 * A tavunu is an imaginary Earth-dwelling being.
 *
 * A tavunu looks a bit like a Patagonian Mara and lives in a non-gendered but
 * hierarchical society. Most interactions among tavuni are negotiated with
 * pava -- items of status used for bargaining.
 *
 * @author Mithat Konar
 * @author Your Name
 */
import java.lang.String;
public abstract class Tavunu
{

    protected String name;
    protected int birthYear;
    protected int pava;

    /* No-argument (default) and parameterized constructors. */

    public Tavunu() {
        name="";
        birthYear = 0;
        pava = 0;
    }

    public Tavunu(String name, int birthYear, int pava) {
  
        this.name = name;
        this.birthYear = birthYear;
        this.pava = pava;
    }

    /* setName(name): gives the tavunu a new name. All tavunu names begin with the letters 'T' or 'D'.
    If the desired new name does not meet this criterion, the method does not change the name and returns false.
    Otherwise it changes the tavunu's name and returns true.
     */

    public boolean setName(String name) {
        if(name == "")
        {
            return true;
        }
        if (name.charAt(0) == 'T' || name.charAt(0) == 'D')
        {
            this.name = name;
            return true;

        }

        else
        {
            return false;
        }
    }

    /* getName(): returns the tavunu's name. */

    public String getName() {
        return name;
    }

    /* spendPava(amount): decreases the amount of pava held by the tavunu.
    If the amount is zero or less the method does not change the pava and returns false.
    Otherwise it subtracts the amount from the tavunu's pava and returns true.
     */

    public boolean spendPava(int pava) {
        if (pava >= 0 && pava <= this.pava) {
            this.pava -= pava;
            return true;
        } else {
            return false;
        }
    }

    /* receivePava(amount): increases the amount of pava held by the tavunu.
    If the amount is zero or less it does not change the pava and it returns false.
    Otherwise it adds the amount to the tavunu's pava and returns true.
     */

    public boolean receivePava(int pava) {
        if (pava >= 0 && pava <= this.pava) {
            this.pava += pava;
            return true;
        } else {
            return false;
        }
    }

    /* getPava(): returns the amount of pava held by this tavunu. */

    public int getPava() {
        return pava;
    }

    public int getBirthYear() {
        return birthYear;
    }
                                                    /* Accessor and mutator for the year of their birth. Negative values are OK --- they correspond to BCE dates. */

    public void setBirthYear(int birthYear) {
        this.birthYear=birthYear;
    }

    /* An appropriate toString() method */

    public String toString() {
        return name + " born in " + birthYear + " has " + pava + " pava.";
    }

}

