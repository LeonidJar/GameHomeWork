import java.util.ArrayList;
import java.util.Random;

public class Monk extends SupportUnit {

    public Monk(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative + 2, 10, 5, 2, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Monk [" + coordinates.x + ", " + coordinates.y + "] mana: " + manaPoints + "/" + 10 + " HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        super.step(enemy, allys);
        Unit tmpAlly = allys.get(0);
        double minAllyHealth = 1;

        if (!isAlive) return;

        for (Unit unit: allys) {
            if (unit.currentHealth / unit.health < minAllyHealth && unit.isAlive) {
                minAllyHealth = unit.currentHealth / unit.health;
                tmpAlly = unit;
            } 
        }

        if (minAllyHealth < 1 && manaPoints > 0) {
            tmpAlly.getDamage(-damage);
            manaPoints -= 1;
            state = "Healing";

            return;
        }
    }
}
