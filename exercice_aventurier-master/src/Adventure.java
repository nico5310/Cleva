import java.io.FileNotFoundException;
import java.util.List;


public class Adventure {

    public static void main(String[] args) throws FileNotFoundException {
        List<TestCase> testsCases = TestCase.initTestCases();
        Map map = new Map();

        for (TestCase testCase : testsCases) {
            char[] directions = testCase.getMovesInstructions();
            Adventurer adventurer = new Adventurer(testCase);

            runAdventure(testCase, directions, map, adventurer);

            result(testCase, adventurer, map);
        }
    }

    private static void result(TestCase testCase, Adventurer adventurer, Map map) {
        if (adventurer.isAliveAndInsideMap(map, testCase)) {
            System.out.println(
                    "testCase " +
                            testCase.getIndex() +
                            " - At the end adventure, Indy is still alive and his position is " +
                            adventurer.getX() +
                            " , " +
                            adventurer.getY() +
                            " as expected."

            );
        }
    }

    private static void runAdventure(TestCase testCase, char[] directions, Map map, Adventurer adventurer) {
        for (int indexDirection = 0; indexDirection < directions.length; indexDirection++) {
            try {
                char tile = map.getTile(adventurer.getX(), adventurer.getY());
                if (isImpenetrableWood(tile)) {
                    handleCaseImpenetrableWood(testCase, indexDirection);
                    break;
                }
                adventurer.move(directions[indexDirection]);
                testCase.setValid(true);
            } catch (ArrayIndexOutOfBoundsException error) {
                System.err.println("testCase " +
                        testCase.getIndex() +
                        " - Failed!! Indy you get out of the map!");
                break;
            }

        }
    }

    private static void handleCaseImpenetrableWood(TestCase testCase, int indexDirection) {
        if (isIndyDropedInWood(indexDirection)) {
            System.err.println("testCase " +
                    testCase.getIndex() +
                    " - You were droped directly into impenetrable wood... You are dead.");
            return;
        }
        System.err.println("testCase " +
                testCase.getIndex() +
                " - You cannot enter this impenetrable wood!! You are dead.");
    }

    private static boolean isIndyDropedInWood(int indexDirection) {
        return indexDirection == 0;
    }

    private static boolean isImpenetrableWood(char tile) {
        return tile == '#';
    }

}