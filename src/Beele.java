public class Beele extends Tavunu {

    public Beele(String name, int birthYear, int pava)
    {
        super(name, birthYear, pava);

        if(pava < 21 || pava > 80)
        {
            throw new IllegalArgumentException("invalid pava amount");
        }
    }
    @Override
    public String toString() {
        return name + " born in " + birthYear + " is a Beele with " + pava + " pava.";
    }
}
