package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationOrder {
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

        for (int n = 1; n < N; n++){
            for (int i = 0; i+n < N; i++) {
                dp[i][i+n] = Integer.MAX_VALUE;
                for (int k = i; k < n+i; k++) {
                    dp[i][n+i] = Math.min(dp[i][n+i],dp[i][k]+dp[k+1][i+n] + arr[i][0]*arr[k][1]*arr[i+n][1]);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
