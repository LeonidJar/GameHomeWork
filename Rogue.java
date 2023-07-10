public class Rogue extends MeleeUnit {

    public Rogue(int x, int y, int initiative) {
        super(x, y, initiative + 4, 5, 2, 2, 1);
    }
    
    // @Override
    // public void step(ArrayList<Unit> enemy, ArrayList<Unit> allyPeasant) {
    //     Unit tmp = findClosestEnemy(enemy);
    //     System.out.println(getInfo() + " -> " + tmp.getInfo() + " distance: " + (int)coordinates.countDistance(tmp.coordinates));
    // }

    @Override
    public String getInfo() {
        return "Rogue [" + coordinates.x + ", " + coordinates.y + "]";
    }

}
