import java.util.ArrayList;

public abstract class Unit implements InGameInterface {

    public int[] position; // [x,y]

    public int currentHealth;
    public int health;
    public int damage;
    public int moveDistance;
    
    public int initiative;

    public boolean isAlive;

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


    public void move(Coordinates targetPosition) {
        for (int i = 0; i < moveDistance; i++) {
            //если по координате Х больше растояние 
            if (Math.abs(targetPosition.x - coordinates.x) > Math.abs(targetPosition.y - coordinates.y)) {
                if (targetPosition.x - coordinates.x > 0) coordinates.x += 1;
                else coordinates.x -= 1;
            }

            //если по координате Y больше растояние
            if (Math.abs(targetPosition.x - coordinates.x) < Math.abs(targetPosition.y - coordinates.y)) {
                if (targetPosition.y - coordinates.y > 0) coordinates.y += 1;
                else coordinates.y -= 1;
            }

            //если находится ровно по диагонали
            if (Math.abs(targetPosition.x - coordinates.x) == Math.abs(targetPosition.y - coordinates.y)) {
                if (targetPosition.x - coordinates.x > 0) {
                    coordinates.x += 1;
                    coordinates.y += 1;
                }
                else {
                    coordinates.x -= 1;
                    coordinates.y -= 1;
                }
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
        }
    }


    public void getHeal(int heal) {
        currentHealth += heal;

        if (currentHealth >= health) currentHealth = health;
    }
}
