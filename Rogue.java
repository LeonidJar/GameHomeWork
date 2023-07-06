public class Rogue extends MeleeUnit {

    public Rogue(int[] position, int initiative) {
        super(position, initiative, 2, 1);
    }
    
    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Rogue";
    }

}
