public abstract class MeleeUnit extends Unit {

    public int attacksAmount;
    public int attackRange;

    public MeleeUnit(int[] position, int initiative, int attacksAmount, int attackRange) {
        super(position, 100, 10, 1, initiative, true);

        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;
    }

        
}
