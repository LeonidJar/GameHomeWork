import java.util.ArrayList;

public abstract class RangeUnit extends Unit {

    public int attackRange;
    public int ammoAmount;
    public int timeToLoad;

    public RangeUnit(int x,int y, int initiative, int attackRange, int ammoAmount, int timeToLoad) {
        super(x, y, 50, 50, 5, 1, initiative, true);

        this.attackRange = attackRange;
        this.ammoAmount = ammoAmount;
        this.timeToLoad = timeToLoad;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        Unit tmp = findClosestEnemy(enemy);

        if (isAlive) {
            for (Unit unit: allys) {
                if (unit instanceof Peasant && unit.state == "Stand" && ammoAmount < 20 && this instanceof Archer) {
                    ammoAmount += 1;
                    unit.state = "Busy";
                    return;
                }
            }

            if ((int)coordinates.countDistance(tmp.coordinates) <= attackRange) {
                if (ammoAmount > 0) {
                    tmp.getDamage(damage);
                    ammoAmount -= 1;
                    state = "Attack";
                    return;
                } 
            } else {
                move(tmp.coordinates);
                state = "Moving";
                return;
            }
        }

        return;
    }
    
}
