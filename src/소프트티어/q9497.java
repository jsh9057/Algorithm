package 소프트티어;
import java.util.*;
import java.io.*;
public class q9497 {
    static int[][] map;
    static boolean[][] visit;
    static int[][] ret;
    static final int[] dx={1,-1,0,0};
    static final int[] dy={0,0,1,-1};
    static int N;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ret = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            String[] split = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(split[j]);
            }
        }

        int region = 1;
        for(int i=0;i<N;i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    go(i,j,region++,new boolean[N+1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0; j<N; j++){
                sb.append(ret[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static void go(int y, int x, int r, boolean[] numCheck){
        if(visit[y][x]){ return; }
        if(numCheck[map[y][x]]){ return; }

        visit[y][x]=true;
        ret[y][x]=r;
        numCheck[map[y][x]]=true;

        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(isRange(ny,nx) && !visit[ny][nx] && !numCheck[map[ny][nx]]){
                go(ny,nx,r,numCheck);
            }
        }
    }

    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<=x && x<N; }
}
