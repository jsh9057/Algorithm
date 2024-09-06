package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) { arr[i] = Integer.parseInt(split[i-1]); }

        int[][] dp = new int[N+1][N+1];

        dp[1][1]=1;
        for (int i = 2; i <= N ; i++) {
            dp[i][i]=1;
            if(arr[i]==arr[i-1]){ dp[i-1][i] = 1; }
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j+i <= N; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]==1){ dp[j][j+i] = 1; }
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            sb.append(dp[Integer.parseInt(split[0])][Integer.parseInt(split[1])]).append("\n");
        }
        System.out.print(sb);
    }
}
