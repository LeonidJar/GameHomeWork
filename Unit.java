public abstract class Unit implements InGameInterface {

    public int[] position; // [x,y]

    public int currentHealth;
    public int health;
    public int damage;
    public int moveDistance;
    
    public int initiative;

    public boolean isAlive;

    public Unit(int[] position, int currentHealth, int health, int damage, int moveDistance, int initiative, boolean isAlive) {
        this.position = position;
        this.currentHealth  = currentHealth;
        this.health = health;
        this.damage = damage;
        this.moveDistance = moveDistance;
        this.initiative = initiative;
        this.isAlive = isAlive;
    }


    public int[] move(int[] targetPosition) {
        while (moveDistance > 0 || position != targetPosition) {
            //если по координате Х больше растояние 
            if (Math.abs(targetPosition[0] - position[0]) > Math.abs(targetPosition[1] - position[1])) {
                if (targetPosition[0] - position[0] > 0) position[0] += 1;
                else position[0] -= 1;
            }

            //если по координате У больше растояние
            if (Math.abs(targetPosition[1] - position[1]) > Math.abs(targetPosition[0] - position[0])) {
                if (targetPosition[1] - position[1] > 0) position[1] += 1;
                else position[1] -= 1;
            }

            //если находится ровно по диагонали
            if (Math.abs(targetPosition[0] - position[0]) == Math.abs(targetPosition[1] - position[1])) {
                if (targetPosition[0] - position[0] > 0) {
                    position[0] += 1;
                    position[1] += 1;
                }
                else {
                    position[0] -= 1;
                    position[1] -= 1;
                }
            }
        } 

        return position;
    }


    public void getDamage(int damage) {
        currentHealth -= damage;

        if (currentHealth <= 0) {
            isAlive = false;
            currentHealth = 0;
        }
    }


    public void getHeal(int heal) {
        currentHealth += heal;

        if (currentHealth >= health) currentHealth = health;
    }
}
