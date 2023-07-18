import java.util.ArrayList;
import java.util.Random;

public class Mage extends SupportUnit {

    public Mage(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative + 2, 100, 10, 3, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Mage [" + coordinates.x + ", " + coordinates.y + "] mana: " + manaPoints + "/" + 10 + " HP: " + currentHealth + "/" + health + " " + state;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        if (!isAlive) return;

        super.step(enemy, allys);
        ArrayList<Unit> deadTeammates = new ArrayList<>();
        Unit tmpAlly = allys.get(0);

        if (!isAlive) return;

        for (Unit unit: allys) {
                if (!unit.isAlive) {
                    deadTeammates.add(unit);                
                }
            }

            if (deadTeammates.size() > allys.size() / 2 - 1 && manaPoints >= 5) {
                int n = new Random().nextInt(deadTeammates.size() - 1);

                deadTeammates.get(n).isAlive = true;
                deadTeammates.get(n).currentHealth =  deadTeammates.get(n).health / 2;
                //tmpAlly.state = "Revived";
                state = "Revive";
                manaPoints = 0;
                return;
            }

    }
    
}