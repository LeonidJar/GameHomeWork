import java.util.ArrayList;

public class Monk extends SupportUnit {

    public Monk(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 10, 5, 1, actionPriority);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Monk [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
}
