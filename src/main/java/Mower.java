

class Mower {
    private int x;
    private int y;
    private Direction direction;
    private Field field;
    
    public Mower(int x, int y, Direction direction, Field field) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.field = field;
    }
    
    public void execute(char command) {
        switch (command) {
            case 'D':
                direction = direction.turnRight();
                break;
            case 'G':
                direction = direction.turnLeft();
                break;
            case 'A':
                moveForward();
                break;
            default:
                break;
        }
    }
    
    private void moveForward() {
        int newX = x, newY = y;
        switch (direction) {
            case N:
                newY++;
                break;
            case S:
                newY--;
                break;
            case E:
                newX++;
                break;
            case W:
                newX--;
                break;
        }
        if (field.isWithinField(newX, newY)) {
            x = newX;
            y = newY;
        }
    }
    
    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}