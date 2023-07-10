import java.util.ArrayList;

public abstract class SupportUnit extends Unit {

    public int manaPoints;
    public int magicDamage;
    public int attackRange;
    public int actionPriority; //0 - help; 1 - attack

    public SupportUnit(int x,int y, int initiative, int manaPoints, int magicDamage, int attackRange, int actionPriority) {
        super(x, y, 50, 70, 5, 1, initiative, true);

        this.manaPoints = manaPoints;
        this.magicDamage = magicDamage;
        this.attackRange = attackRange;
        this.actionPriority = actionPriority;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        Unit tmp = findClosestEnemy(enemy);

        if (isAlive) {
            if ((int)coordinates.countDistance(tmp.coordinates) <= attackRange) {
                if (manaPoints > 0) {
                    tmp.getDamage(damage);
                    manaPoints -= 1;

                    System.out.println(getInfo() + " attacking " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates) + " current enemy health: " + tmp.currentHealth);

                } else {
                    manaPoints += 1;
                    System.out.println(getInfo() + " attacking " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates) + " no mana, restoring mana " );

                }
            } else {
                System.out.print(getInfo() + " moving to " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates));
                move(tmp.coordinates);
                System.out.println(" new position [" + coordinates.x + ", " + coordinates.y + "]");
            }
        }
    }
    
}
