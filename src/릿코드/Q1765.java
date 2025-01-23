package 릿코드;
import java.util.*;

public class Q1765 {
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public int[][] highestPeak(int[][] isWater) {
        int N = isWater.length;
        int M = isWater[0].length;
        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(isWater[i][j]==1){ q.add(new int[]{i,j,0}); visit[i][j]=true; }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int ny = now[0]+dy[i];
                int nx = now[1]+dx[i];
                if(isRange(ny,nx,N,M) && !visit[ny][nx]){
                    visit[ny][nx] = true;
                    map[ny][nx]=now[2]+1;
                    q.add(new int[]{ny,nx,now[2]+1} );
                }
            }
        }
        return map;
    }

    boolean isRange(int y, int x, int N, int M){ return 0<= y && y<N && 0<= x && x<M; }
}
