public class Lancer extends MeleeUnit{

    public Lancer(int x, int y, int initiative) {
        super(x, y, initiative + 4, 10, 1, 1, 2);
    }

    @Override
    public String getInfo() {
        return "Lancer [" + coordinates.x + ", " + coordinates.y + "] HP:" + currentHealth + "/" + health + " " + state;
    }
    
    
}