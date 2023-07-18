import java.util.ArrayList;

public class Peasant extends SupportUnit {

    public Peasant(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 0, 0, 1, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Peasant [" + coordinates.x + ", " + coordinates.y + "] HP:" + currentHealth + "/" + health + " " + state;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> allys) {
        if (isAlive) {
            if (state == "Busy") {
                state = "Stand";
            }
        }
    }
}