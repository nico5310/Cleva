import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private char[][] terrainTiles;

    private final String MAP_PATH = "resources/map.txt";

    public Map() throws FileNotFoundException {
        initMap();
    }

    public char getTile(int x, int y) {
        return terrainTiles[y][x];
    }

    public int getWidth() {
        return terrainTiles[0].length;
    }

    public int getHeight() {
        return terrainTiles.length;
    }


    private void initMap() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/map.txt"));
        int numRows = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            numRows++;
        }
        scanner.close();

        terrainTiles = new char[numRows][];

        scanner = new Scanner(new File("resources/map.txt"));
        int yTileIndex = 0;
        while (scanner.hasNextLine()) {
            String row = scanner.nextLine();
            char[] xTile = row.toCharArray();
            terrainTiles[yTileIndex] = xTile;
            yTileIndex++;
        }
        scanner.close();
    }

}
