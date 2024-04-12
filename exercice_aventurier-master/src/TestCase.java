import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCase {
    private static final String ROADMAP_PATH = "resources/instructions.txt";
    private final List<Integer> initialAdventurerPosition;
    private final String movesInstructions;
    public Integer index = 0;
    public boolean isValid = false;

    public TestCase(List<Integer> initialAdventurerPosition, String movesInstructions, Integer index) {
        this.initialAdventurerPosition = initialAdventurerPosition;
        this.movesInstructions = movesInstructions;
        this.index = index;
    }

    public static List<TestCase> initTestCases() throws FileNotFoundException {
        List<TestCase> testCases = new ArrayList<>();
        Scanner scanner = new Scanner(new File(ROADMAP_PATH));
        int index = 0;
        while (scanner.hasNext()) {
            index++;
            List<Integer> coords = new ArrayList<>();
            String[] rowCoords = scanner.nextLine().split(",");
            for (String rowCoor : rowCoords) {
                coords.add(Integer.parseInt(rowCoor));
            }
            testCases.add(new TestCase(coords, scanner.nextLine(), index));

        }
        return testCases;
    }

    public char[] getMovesInstructions() {
        return movesInstructions.toCharArray();
    }

    public Integer getXAdventurerPosition() {
        return initialAdventurerPosition.get(0);
    }

    public Integer getYAdventurerPosition() {
        return initialAdventurerPosition.get(1);
    }

    public Integer getIndex() {
        return index;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
