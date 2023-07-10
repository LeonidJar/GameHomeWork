public class Peasant extends SupportUnit {

    public Peasant(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 0, 0, 1, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Peasant [" + coordinates.x + ", " + coordinates.y + "]";
    }
    
}
