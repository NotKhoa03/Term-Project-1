public class Avo extends Tavunu {

    public Avo(String name, int birthYear, int pava)
    {
        super(name, birthYear, pava);
        if(pava > 20)
        {
            throw new IllegalArgumentException("invalid pava amount");
        }

        if(pava < 10)
        {
            this.pava = 10;
        }
    }

    @Override
    public String toString() {
        return name + " born in " + birthYear + " is an Avo with " + pava + " pava." + "\n";
    }
}