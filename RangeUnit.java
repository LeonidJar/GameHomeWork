import java.util.ArrayList;

public abstract class RangeUnit extends Unit {

    public int attackRange;
    public int ammoAmount;
    public int timeToLoad;

    public RangeUnit(int x,int y, int initiative, int attackRange, int ammoAmount, int timeToLoad) {
        super(x, y, 75, 50, 5, 1, initiative, true);

        this.attackRange = attackRange;
        this.ammoAmount = ammoAmount;
        this.timeToLoad = timeToLoad;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        Unit tmp = findClosestEnemy(enemy);

        if (isAlive) {
            if ((int)coordinates.countDistance(tmp.coordinates) <= attackRange) {
                if (ammoAmount > 0) {
                    tmp.getDamage(damage);
                    ammoAmount -= 1;

                    System.out.println(getInfo() + " attacking " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates) + " current enemy health: " + tmp.currentHealth);

                } else {System.out.println(getInfo() + " attacking " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates) + " no ammo!");}
            } else {
                System.out.print(getInfo() + " moving to " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates));
                move(tmp.coordinates);
                System.out.println(" new position [" + coordinates.x + ", " + coordinates.y + "]");
            }

            if (allys.contains(Peasant.class)) {
                Unit tmpAlly = findClosestEnemy(allys);
                ammoAmount += 1;
                System.out.print(getInfo() + " got ammo from " + tmpAlly.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates) + " ammo added");

            }
        }
    }
    
}
