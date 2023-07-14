import java.util.ArrayList;

public abstract class Unit implements InGameInterface {

    public int[] position; // [x,y]

    public int currentHealth;
    public int health;
    public int damage;
    public int moveDistance;
    
    public int initiative;

    public boolean isAlive;

    // Stand, Dead, Busy, Moving, Attack, Healing, Revive
    public String state = "Stand";

    Coordinates coordinates;


    public Unit(int x, int y, int currentHealth, int health, int damage, int moveDistance, int initiative, boolean isAlive) {
        coordinates = new Coordinates(x, y);
        this.currentHealth  = currentHealth;
        this.health = health;
        this.damage = damage;
        this.moveDistance = moveDistance;
        this.initiative = initiative;
        this.isAlive = isAlive;
    }


    public void move(Coordinates targetPosition, ArrayList<Unit> allys) {
        if (!coordinates.containsByPos(coordinates.newPosition(targetPosition, allys), allys)) {
            for (int i = 0; i < moveDistance; i++) {
                coordinates = coordinates.newPosition(targetPosition, allys);
            } 
        }

    }


    public Unit findClosestEnemy(ArrayList<Unit> units) {
        double minDistance = Double.MAX_VALUE;
        Unit closestEnemy = null;

        for (int i = 0; i < units.size(); i++) {
            if (coordinates.countDistance(units.get(i).coordinates) < minDistance && units.get(i).isAlive) {
                closestEnemy = units.get(i);
                minDistance = coordinates.countDistance(units.get(i).coordinates);
            }
        }

        return closestEnemy;
    }


    public void getDamage(int damage) {
        currentHealth -= damage;

        if (currentHealth <= 0) {
            currentHealth = 0;
            isAlive = false;    
            state = "Dead";        
        }

        if (currentHealth >= health) currentHealth = health;
    }
}
