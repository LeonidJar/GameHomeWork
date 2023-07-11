import java.util.ArrayList;

public class Mage extends SupportUnit {

    public Mage(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative + 2, 10, 10, 3, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Mage [" + coordinates.x + ", " + coordinates.y + "] " + currentHealth + "/" + health + " " + state;
    }
    
}
