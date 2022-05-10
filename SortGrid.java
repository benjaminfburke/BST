public class SortGrid 
{
    private static int compares = 0;
    private static int[][] grid;

    // PUBLIC METHODS
    public static int sort(int[][] thisGrid) 
    {
        compares = 0;
        //TO BE IMPLEMENTED
        grid = thisGrid;
        int s = grid.length * grid.length;
        mergeSort(0, s - 1);
        return compares;
    }

    static void mergeSort(int a, int b) {
        if (b - a == 0) {
        }
        else if(b - a == 1) {
            if (!lessThan(a / grid.length, a % grid.length, b / grid.length, b % grid.length)) {
                swap(a / grid.length, a % grid.length, b / grid.length, b % grid.length);
            }
        }
        else {
            int split = ((int) Math.floor((a + b) / 2));
            mergeSort(a, split);
            mergeSort(split + 1, b);
            int count = a;
            while (count <= split) {
                if (!lessThan(count / grid.length, count % grid.length, (split + 1) / grid.length, (split + 1) % grid.length)) {
                    swap(count / grid.length, count % grid.length, (split + 1) / grid.length, (split + 1) % grid.length);
                    for (int x = split + 1; x < b; x++) {
                        if (!lessThan(x / grid.length, x % grid.length, (x + 1) / grid.length, (x + 1) % grid.length)) {
                            swap(x / grid.length, x % grid.length, (x + 1) / grid.length, (x + 1) % grid.length);
                        }
                    }
                }
                count++;
            }
        }

    }

    //  HELPER METHODS 
    // returns true if value at (r1, c1) is less
    // than value at (r2, c2) and false otherwise;
    // counts as 1 compare
    private static boolean lessThan(int r1, int c1, int r2, int c2) 
    {
        compares++;
        
        if(grid[r1][c1] < grid[r2][c2])
            return true;
        
        return false;
    }

    // returns true if value at (r1, c1) is greater than
    // value at (r2, c2) and false otherwise;
    // counts as 1 compare
    private static boolean greaterThan(int r1, int c1, int r2, int c2) 
    {
        compares++;
        
        if(grid[r1][c1] > grid[r2][c2])
            return true;
        
        return false;
    }
    
    // swaps values in the grid
    // at (r1, c1) and (r2, c2);
    // assumes that the parameters
    // are within the bounds
    private static void swap(int r1, int c1, int r2, int c2) 
    {
        int temp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = temp;
    }
}
