public class Archer extends RangeUnit {

    public Archer(int[] position, int initiative) {
        super(position, initiative, 5, 20, 0);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Archer";
    }
    
}
