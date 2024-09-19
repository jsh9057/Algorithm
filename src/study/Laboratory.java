package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory {
    static int[][] map;
    static ArrayList<int[]> startPoint;
    static int space;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        startPoint = new ArrayList<>();
        space = 0;
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(split[j]);
                if(map[i][j]==2){startPoint.add(new int[]{i,j});}
                else if(map[i][j]==0){space++;}
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N*M; i++) {
            for (int j = i+1; j < N*M; j++) {
                for (int k = j+1; k < N*M; k++) {
                    max = Math.max(max,go(i,j,k));
                }
            }
        }
        System.out.println(max);
    }
    static int go(int w1, int w2, int w3){
        int y1 = w1/M;
        int y2 = w2/M;
        int y3 = w3/M;
        int x1 = w1%M;
        int x2 = w2%M;
        int x3 = w3%M;
        if(map[y1][x1]!=0 || map[y2][x2]!=0 || map[y3][x3]!=0 ){ return 0; }
        else { map[y1][x1]=1; map[y2][x2]=1; map[y3][x3]=1; }

        boolean[][] visit = new boolean[N][M];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int virus = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int[] s: startPoint){
            queue.add(new int[]{s[0],s[1]});
            visit[s[0]][s[1]]=true;
        }

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] +dy[i];
                int nx = now[1] +dx[i];
                if(isRange(ny,nx) && map[ny][nx]==0 && !visit[ny][nx]){
                    visit[ny][nx]=true;
                    virus++;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
        map[y1][x1]=0; map[y2][x2]=0; map[y3][x3]=0;
        return space - virus - 3;
    }
    static boolean isRange(int y, int x){return 0<=y && y<N && 0<=x && x<M; }
}
