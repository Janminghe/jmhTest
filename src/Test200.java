import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * author jmh
 */
public class Test200 {

    public static void main(String[] args) {
        int[][] grid = null;
    }
    //DFS
    public int numIslandsDFS(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }

            }
        }
        return result;
    }


    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        if( i > 0 && grid[i-1][j] == '1'){
            dfs(grid, i - 1, j);
        }
        if( i + 1 < m && grid[i+1][j] == '1'){
            dfs(grid, i + 1, j);
        }
        if(j > 0 && grid[i][j - 1] == '1'){
            dfs(grid, i, j - 1);
        }
        if(j + 1 < n && grid[i][j+1] == '1'){
            dfs(grid, i ,j + 1);
        }
    }

    //BFS
    public void bfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<List<Integer>> queue = new ArrayDeque();
        List<Integer> init = new ArrayList<>();
        init.add(i);
        init.add(j);
        queue.add(init);
        while(!queue.isEmpty()){
            int temp = queue.size();
            while(temp > 0){
                List<Integer> tempList = queue.remove();
                int tempi = tempList.get(0);
                int tempj = tempList.get(1);
                grid[tempi][tempj] = '0';
                if(tempi > 0 && grid[tempi - 1][tempj] == '1'){
                    List<Integer> list = new ArrayList<>();
                    list.add(tempi - 1);
                    list.add(tempj);
                    queue.add(list);
                }
                if(tempi < m - 1 && grid[tempi + 1][tempj] == '1'){
                    List<Integer> list = new ArrayList<>();
                    list.add(tempi + 1);
                    list.add(tempj);
                    queue.add(list);
                }
                if(tempj > 0 && grid[tempi][tempj - 1] == '1'){
                    List<Integer> list = new ArrayList<>();
                    list.add(tempi);
                    list.add(tempj - 1);
                    queue.add(list);
                }
                if(tempj < n - 1 && grid[tempi][tempj + 1] == '1'){
                    List<Integer> list = new ArrayList<>();
                    list.add(tempi);
                    list.add(tempj + 1);
                    queue.add(list);
                }
                temp--;
            }
        }
    }

    //BFS
    public int bfs1(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int countOfIsland = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    countOfIsland++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.add(i * n + j);
                    while(!queue.isEmpty()){
                        int temp = queue.remove();
                        int row = temp / n;
                        int col = temp % n;
                        if(row > 0 && grid[row - 1][col] == '1'){
                            queue.add((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if(row + 1 < m && grid[row + 1][col] == '1'){
                            queue.add((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if(col > 0 && grid[row][col - 1] == '1'){
                            queue.add(row * n + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if(col + 1 < n && grid[row][col + 1] == '1'){
                            queue.add(row * n + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return countOfIsland;
    }
}
