import java.util.ArrayList;

public class Archer extends RangeUnit {

    public Archer(int x, int y, int initiative) {
        super(x, y, initiative, 5, 20, 0);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Archer [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
}
