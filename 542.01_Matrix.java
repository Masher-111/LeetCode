import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix {
   
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>(); 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rowColIndex = queue.poll();
                for (int[] step : steps) {
                    int row = rowColIndex[0] + step[0];
                    int col = rowColIndex[1] + step[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || mat[row][col] != Integer.MAX_VALUE){
                        continue;
                    }
                    queue.add(new int[] {row, col});
                    mat[row][col] = distance;
                }
            }
        }
        
        return mat;



    }
  

public static void main(String[] args) {
    int [][] desk =
    {
        {0,0,0},
        {0,1,0},
        {1,1,1}};

updateMatrix(desk);   
for (int i = 0; i < desk.length; i++) {
    for (int j = 0; j < desk[0].length; j++) {
        System.out.print(desk[i][j]);
    }
}
}
}
