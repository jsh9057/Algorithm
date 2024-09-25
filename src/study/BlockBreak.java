package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BlockBreak {
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String in  = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=in.charAt(j)-'0';
            }
        }

        boolean[][][] visit = new boolean[N][M][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1,0});  // y,x,move,break
        visit[0][0][0] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==N-1 && now[1]==M-1){ System.out.println(now[2]); return; }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i]+now[0];
                int nx = dx[i]+now[1];
                if(isRange(ny,nx) && !visit[ny][nx][now[3]]){
                    if(map[ny][nx]==1){
                        if(now[3]==1){ continue; }
                        visit[ny][nx][1]=true;
                        queue.add(new int[]{ny,nx,now[2]+1,1});
                    }
                    else{
                        visit[ny][nx][now[3]]=true;
                        queue.add(new int[]{ny,nx,now[2]+1,now[3]});
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static boolean isRange(int y, int x){ return 0<=y&&y<N&&0<=x&&x<M; }
}
