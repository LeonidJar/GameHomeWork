import java.util.ArrayList;

public class Sniper extends RangeUnit {

    public Sniper(int x, int y, int initiative) {
        super(x, y, initiative, 7, 100, 1);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Sniper [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
}
