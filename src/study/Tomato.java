package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        int[][] box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int notRipe = 0;
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j]=Integer.parseInt(split[j]);
                if(box[i][j]==1){ queue.add(new int[]{i,j,0}); }
                else if(box[i][j]==0){ notRipe++; }
            }
        }

        if(notRipe == 0 ){ System.out.println(0); return; }
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + now[0];
                int nx = dx[i] + now[1];
                if(isRange(ny,nx,M,N) && box[ny][nx]==0){
                    box[ny][nx]=1;
                    queue.add(new int[]{ny,nx,now[2]+1});
                    notRipe--;
                    if(notRipe == 0){ System.out.println(now[2]+1); return; }
                }
            }
        }
        System.out.println(-1);
    }
    static boolean isRange(int y, int x, int M, int N){ return 0<=y && y<N && 0<=x && x<M; }
}
