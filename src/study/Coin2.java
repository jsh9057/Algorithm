package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] c = new int[N];
        for (int i = 0; i < N; i++) { c[i]=Integer.parseInt(br.readLine()); }
        int[] dp = new int[K+1];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        for (int i = 0; i < N; i++) {
            if(c[i]>K){ continue; }
            dp[c[i]]=1;
            for (int j = c[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j-c[i]] + dp[c[i]],dp[j]);
            }
        }
        System.out.println(dp[K]>K ? -1:dp[K]);
    }
}
