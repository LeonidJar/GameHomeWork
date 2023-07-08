import java.util.ArrayList;

public class Rogue extends MeleeUnit {

    public Rogue(int x, int y, int initiative) {
        super(x, y, initiative, 2, 1);
    }
    
    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Rogue [" + coordinates.x + ", " + coordinates.y + "]";
    }

}
