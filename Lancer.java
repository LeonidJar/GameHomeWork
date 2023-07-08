import java.util.ArrayList;

public class Lancer extends MeleeUnit{

    public Lancer(int x, int y, int initiative) {
        super(x, y, initiative, 1, 2);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = findClosestEnemy(units);
        System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + coordinates.countDistance(tmp.coordinates));
    }

    @Override
    public String getInfo() {
        return "Lancer [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
    
}
