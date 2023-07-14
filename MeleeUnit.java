import java.util.ArrayList;

public abstract class MeleeUnit extends Unit {

    public int attacksAmount;
    public int attackRange;

    public MeleeUnit(int x,int y, int initiative, int damage, int moveDistance, int attacksAmount, int attackRange) {
        super(x, y, 100, 100, damage, moveDistance, initiative, true);

        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;
    }

    // @Override
    // public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
    //     Unit tmp = findClosestEnemy(enemy);

    //     if (isAlive) {
    //         if ((int)coordinates.countDistance(tmp.coordinates) <= attackRange) {
    //             tmp.getDamage(damage);
    //             state = "Attack";
    //             return;
    //         } else {
    //             move(tmp.coordinates);
    //             state = "Moving";
    //             return;
    //         }
    //     }
    //     return;
    // }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        if (!isAlive) return;

        Unit tmp = findClosestEnemy(enemy);

        if (coordinates.countDistance(tmp.coordinates) <= attackRange) {
            for (int i = 0; i < attacksAmount; i++) tmp.getDamage(damage);
            state = "Attack";
        } else {
            move(tmp.coordinates, allys);
            state = "Moving";
        }
    }
        
}
