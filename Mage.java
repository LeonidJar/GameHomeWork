import java.util.ArrayList;

public class Mage extends SupportUnit {

    public Mage(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 10, 10, 3, actionPriority);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Mage [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
}
