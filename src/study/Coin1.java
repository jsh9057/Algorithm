package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] c = new int[N];
        for (int i = 0; i < N; i++) { c[i] = Integer.parseInt(br.readLine()); }
        Arrays.sort(c);

        int[][] dp = new int[N][K+1];
        for (int k = 0; k <= K; k++) {
            for (int n = 0; n < N; n++) {
                if(k==0){ dp[n][k]=1; continue; }
                if(k<c[n]){
                    if(n==0){continue;}
                    dp[n][k]=dp[n-1][k]; continue; }
                for (int i = 0; i <= n; i++) {
                    dp[n][k]+=dp[n-i][k-c[n-i]];
                }
            }
        }
        System.out.println(dp[N-1][K]);
    }
}