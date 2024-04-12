public class Adventurer {
    private int x;
    private int y;

    public Adventurer(TestCase testCase) {
        this.x = testCase.getXAdventurerPosition();
        this.y = testCase.getYAdventurerPosition();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(char direction) {
        switch (direction) {
            case 'N':
                y--;
                break;
            case 'S':
                y++;
                break;
            case 'O':
                x--;
                break;
            case 'E':
                x++;
                break;
        }
    }

    public boolean isInsideMap(Map map) {
        return x > 0 && y > 0 && x < map.getWidth() && y < map.getHeight();
    }

    public boolean isAliveAndInsideMap(Map map, TestCase testCase) {
        return isInsideMap(map) && testCase.isValid;
    }
}
