public class MineSweeper {
    public static void main(String[] args) {
        String[][] map = {{"*", ".", ".", "."}, {".", "*", ".", "."}, {"*", "*", ".", "."}, {".", ".", ".", "."}};

        final int MAP_WIDTH = map[0].length;
        final int MAP_HEIGHT = map.length;
        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];

        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                String currentCell = map[i][j];
                if (currentCell.equals("*")) {
                    mapReport[i][j] = "*";
                } else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                            {i, j - 1}, {i, j + 1},
                            {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1},
                    };
                    int minesAround = 0;
                    for (int x = 0; x < NEIGHBOURS_ORDINATE.length; x++) {
                        int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[x];
                        int xOrdinateOfNeighbour = neighbourOrdinate[1];
                        int yOrdinateOfNeighbour = neighbourOrdinate[0];

                        boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0
                                || xOrdinateOfNeighbour == MAP_WIDTH
                                || yOrdinateOfNeighbour < 0
                                || yOrdinateOfNeighbour == MAP_HEIGHT;
                        if (isOutOfMapNeighbour) continue;

                        boolean isMineOwnerNeighbour = map[yOrdinateOfNeighbour][xOrdinateOfNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }
                    mapReport[i][j] = String.valueOf(minesAround);
                }
            }
        }
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                String currentCellReport = mapReport[i][j];
                System.out.print(currentCellReport);
            }
            System.out.printf("\n");
        }
    }
}