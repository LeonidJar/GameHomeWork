import java.util.ArrayList;

public class Peasant extends SupportUnit {

    public Peasant(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 0, 0, 1, actionPriority);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Peasant [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
}
