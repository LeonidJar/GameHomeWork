public class Sniper extends RangeUnit {

    public Sniper(int[] position, int initiative) {
        super(position, initiative, 7, 100, 1);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Sniper";
    }
    
}
