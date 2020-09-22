public class Player extends Moveable
{
    private boolean readyToStart;
    private boolean readyToDropFood;
    private int foodCellCount;
    Cell foodCell;

    public Player(final Grid g, final int row, final int col) throws Exception {
        super(g);
        this.readyToStart = false;
        this.readyToDropFood = false;
        this.foodCellCount = 0;
        this.foodCell = new Cell(-1, -1);
        this.currentCell = this.grid.getCell(row, col);
        this.currentDirection = ' ';
    }

    public Cell move() {
        return this.currentCell = this.grid.getCell(this.currentCell, this.currentDirection);
    }

    public int maxCellsPerMove() {
        return 1;
    }

    public int pointsRemaining() {
        return -1;
    }

    public void setReady(final boolean val) {
        this.readyToStart = val;
    }

    public boolean isReady() {
        return this.readyToStart;
    }

    public boolean isDropFood() {
        return this.readyToDropFood;
    }

    public Cell getFoodCell() {
        if (this.foodCellCount < 1 && this.readyToDropFood) {
            this.foodCell = this.currentCell;
            ++this.foodCellCount;
        }
        return this.foodCell;
    }

    public void setDropFood(final boolean val) {
        this.readyToDropFood = val;
    }
}
