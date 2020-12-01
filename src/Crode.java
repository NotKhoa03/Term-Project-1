public class Crode extends Tavunu{

    public Crode(String name, int birthYear, int pava)
    {
        super(name, 1, pava);
        if(pava <= 80)
        {
            throw new IllegalArgumentException("invalid pava amount");
        }

        if(birthYear%2 == 0)
        {
            throw new IllegalArgumentException("invalid year");
        }
        else
        {
            this.birthYear = birthYear;
        }
    }
    @Override
    public void setBirthYear(int birthYear) {
        if(birthYear%2 == 0)
        {
            throw new IllegalArgumentException("invalid year");
        }
        else
            this.birthYear=birthYear;
    }
    @Override
    public String toString() {
        return name + " born in " + birthYear + " is a Crode with " + pava + " pava.";
    }
}