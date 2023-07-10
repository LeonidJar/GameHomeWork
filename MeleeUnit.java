import java.util.ArrayList;

public abstract class MeleeUnit extends Unit {

    public int attacksAmount;
    public int attackRange;

    public MeleeUnit(int x,int y, int initiative, int damage, int moveDistance, int attacksAmount, int attackRange) {
        super(x, y, 100, 100, damage, moveDistance, initiative, true);

        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        Unit tmp = findClosestEnemy(enemy);

        if (isAlive) {
            if ((int)coordinates.countDistance(tmp.coordinates) <= attackRange) {
                tmp.getDamage(damage);

                System.out.println(getInfo() + " attacking " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates) + " current enemy health: " + tmp.currentHealth);
            } else {
                System.out.print(getInfo() + " moving to " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates));
                move(tmp.coordinates);
                System.out.println(" new position [" + coordinates.x + ", " + coordinates.y + "]");
            }
        }
    }
        
}
