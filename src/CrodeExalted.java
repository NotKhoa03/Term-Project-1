public class CrodeExalted extends Crode{
    public CrodeExalted(String name, int birthYear, int pava) {
        // pass 1 as birthYear to Crode ctor so name and pava are configured
        super(name, 1, pava);

        // then check birthYear parameter to see if we have a valid CrodeExalted
        if(birthYear%2 == 1)
        {
            throw new IllegalArgumentException("invalid year");
        }

        else
        {
            this.birthYear = birthYear;
        }

        if(pava <= 80)
        {
            throw new IllegalArgumentException("invalid pava amount");
        }


    }
    @Override
    public void setBirthYear(int birthYear) {
        if(birthYear%2 == 1)
        {
            throw new IllegalArgumentException("invalid year");
        }
        else
            this.birthYear=birthYear;
    }
    @Override
    public String toString() {
        return name + " born in " + birthYear + " is an Exalted Crode with " + pava + " pava." + "\n";
    }
}
