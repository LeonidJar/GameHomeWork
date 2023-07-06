public class Lancer extends MeleeUnit{

    public Lancer(int[] position, int initiative) {
        super(position, initiative, 1, 2);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Lancer";
    }
    
    
}
