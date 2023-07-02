public abstract class Unit {

    public String name;

    public int[] position;

    public int health;
    public int armorClass;
    public int moveDistance;
    
    public int initiative;

    public boolean isAlive;

    public Unit(String name, int[] position, int health, int armorClass, int moveDistance, int initiative, boolean isAlive) {
        this.name = name;
        this.position = position;
        this.health = health;
        this.armorClass = armorClass;
        this.moveDistance = moveDistance;
        this.initiative = initiative;
        this.isAlive = isAlive;
    }

    public int[] move(int[] targetPosition) {
        while (moveDistance >= 0 || position != targetPosition) {
            position[]
        } 

        return position;
    }
    
}
