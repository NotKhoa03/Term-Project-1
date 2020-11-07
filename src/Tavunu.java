
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

    public Tavunu() {
        name="";
        birthYear = Integer.MIN_VALUE;
        pava = 0;
    }

    public Tavunu(String name, int birthYear, int pava) {
        super();
        this.name = name;
        this.birthYear = birthYear;
        this.pava = pava;
    }

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


    public String getName() {
        return name;
    }

    public boolean spendPava(int pava) {
        if (pava >= 0 && pava <= this.pava) {
            this.pava -= pava;
            return true;
        } else {
            return false;
        }
    }

    public boolean receivePava(int pava) {
        if (pava >= 0 && pava <= this.pava) {
            this.pava += pava;
            return true;
        } else {
            return false;
        }
    }

    public int getPava() {
        return pava;
    }

    public int getBirthYear() {
        return birthYear;
    }


    public void setBirthYear(int birthYear) {
        this.birthYear=birthYear;
    }

    public String toString() {
        return name + " born in " + birthYear + " has " + pava + " pava.";
    }

}

