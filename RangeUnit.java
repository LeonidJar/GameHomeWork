public abstract class RangeUnit extends Unit {

    public int attackRange;
    public int ammoAmount;
    public int timeToLoad;

    public RangeUnit(int[] position, int initiative, int attackRange, int ammoAmount, int timeToLoad) {
        super(position, 75, 75, 5, 1, initiative, true);

        this.attackRange = attackRange;
        this.ammoAmount = ammoAmount;
        this.timeToLoad = timeToLoad;
    }
    
}
