package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pipe {
    static final int[] dx = {0,1,1,0};
    static final int[] dy = {0,0,1,1};
    static int[][][] dp;    // [][][d] d: 0 원본 1 가로 2 대각 3 세로
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N][4];
        dp[0][1][1]=1;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = Integer.parseInt(split[j]);
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(dp[y][x][0]==1){ continue; }
                if(dp[y][x][1]>0){
                    if(isGo(y,x,1)){ dp[y+dy[1]][x+dx[1]][1]+=dp[y][x][1]; }
                    if(isGo(y,x,2)){ dp[y+dy[2]][x+dx[2]][2]+=dp[y][x][1]; }
                }
                if(dp[y][x][2]>0){
                    if(isGo(y,x,1)){ dp[y+dy[1]][x+dx[1]][1]+=dp[y][x][2]; }
                    if(isGo(y,x,2)){ dp[y+dy[2]][x+dx[2]][2]+=dp[y][x][2]; }
                    if(isGo(y,x,3)){ dp[y+dy[3]][x+dx[3]][3]+=dp[y][x][2]; }
                }
                if(dp[y][x][3]>0){
                    if(isGo(y,x,2)){ dp[y+dy[2]][x+dx[2]][2]+=dp[y][x][3]; }
                    if(isGo(y,x,3)){ dp[y+dy[3]][x+dx[3]][3]+=dp[y][x][3]; }
                }
            }
        }
        System.out.println(dp[N-1][N-1][1]+dp[N-1][N-1][2]+dp[N-1][N-1][3]);
    }

    static boolean isGo(int y, int x, int dir){
        if(dir == 2){
            for (int i = 1; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(!isRange(ny,nx)){return false; }
                if(dp[ny][nx][0]==1){ return false; }
            }
           return true;
        }
        else{
            int nx = dx[dir]+x;
            int ny = dy[dir]+y;
            return isRange(ny, nx) && dp[ny][nx][0] == 0;
        }
    }
    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<= x && x<N; }
}
