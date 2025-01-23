package 릿코드;
import java.util.*;

public class Q1267 {
    public int countServers(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[] yCount = new int[N];
        int[] xCount = new int[M];

        int totalCom = 0;
        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==1){
                    yCount[i]++;
                    xCount[j]++;
                    totalCom++;
                }
            }
        }
        int isolationCom = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==0){ continue; }
                if(xCount[j]==1 && yCount[i]==1){
                    xCount[j]--;
                    yCount[i]--;
                    isolationCom++;
                }
            }
        }
        return totalCom - isolationCom;
    }
}
