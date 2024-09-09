package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationOrder {
/*
3
5 3
3 2
2 6
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }
        // dp[n][k] -> n부터 k만큼 왼쪽으로 묶음
        for (int k = 1; k <  N; k++) {
            for (int n = k; n < N ; n++) {
                if(k==1){ dp[n][k] = Math.min(arr[n-k][0]*arr[n][0]*arr[n][1],dp[n][k]); }
                else{
                    dp[n][k] = Math.min(dp[n-1][k-1]+(arr[n-k][0]*arr[n][0]*arr[n][1]),dp[n][k]);
                    dp[n][k] = Math.min(dp[n][k-1]+(arr[n-k][0]*arr[n-k][1]*arr[n][1]),dp[n][k]);
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
