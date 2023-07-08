public abstract class MeleeUnit extends Unit {

    public int attacksAmount;
    public int attackRange;

    public MeleeUnit(int x,int y, int initiative, int attacksAmount, int attackRange) {
        super(x, y, 100, 100, 10, 1, initiative, true);

        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;
    }

        
}
