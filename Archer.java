public class Archer extends RangeUnit {

    public Archer(int x, int y, int initiative) {
        super(x, y, initiative + 3, 5, 20, 0);
    }

    @Override
    public String getInfo() {
        return "Archer [" + coordinates.x + ", " + coordinates.y + "] " + ammoAmount + " " + currentHealth + "/" + health + " " + state;
    }    
}
