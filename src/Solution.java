import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static class Cell {
        private int x;
        private int y;
        private int cellPerimeter;

        public Cell(int x, int y, int cellPerimeter) {
            this.x = x;
            this.y = y;
            this.cellPerimeter = cellPerimeter;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCellPerimeter() {
            return cellPerimeter;
        }

        public void setCellPerimeter(int cellPerimeter) {
            this.cellPerimeter = cellPerimeter;
        }
    }

    public static Cell getCellByСoordinates(List<Cell> cells, int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public static int islandPerimeter(int[][] grid) {
        List<Cell> cells = new ArrayList<>();
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    cells.add(new Cell(i, j, 4));
                }
            }
        }

        for (Cell cell : cells) {
            //check upper cell
            if (getCellByСoordinates(cells, cell.getX(), cell.getY()-1) != null){
                cell.setCellPerimeter(cell.getCellPerimeter() - 1);
            }
            //check lower cell
            if (getCellByСoordinates(cells, cell.getX(), cell.getY() + 1) != null){
                cell.setCellPerimeter(cell.getCellPerimeter() - 1);
            }
            //check left cell
            if (getCellByСoordinates(cells, cell.getX() - 1, cell.getY()) != null){
                cell.setCellPerimeter(cell.getCellPerimeter() - 1);
            }

            //check right cell
            if (getCellByСoordinates(cells, cell.getX() + 1, cell.getY()) != null){
                cell.setCellPerimeter(cell.getCellPerimeter() - 1);
            }

            perimeter += cell.getCellPerimeter();
        }
        return perimeter;
    }
}
