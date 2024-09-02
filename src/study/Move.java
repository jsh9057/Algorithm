package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Move {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        int[][] dp = new int[N][M];
        dp[0][0] = map[0][0];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if(isRange(i,j+1,N,M)){ dp[i][j+1]=Math.max(dp[i][j+1],dp[i][j]+map[i][j+1]); }
                if(isRange(i+1,j+1,N,M)) { dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i][j]+map[i+1][j+1]);}
                if(isRange(i+1,j,N,M)){ dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]+map[i+1][j]); }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }

    static boolean isRange(int y, int x, int N , int M){ return 0<=y && y<N && 0<=x && x<M; }
}
