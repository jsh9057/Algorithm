package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) { A[i]=Integer.parseInt(split[i]); }

        int ret = -1;
        int[] dp = new int[N];
        for (int n = 0; n < N; n++) {
            dp[n]=1;
            for (int k = 0; k < n; k++) {
                if(A[n]>A[k]){ dp[n] = Math.max(dp[k]+1, dp[n]); }
            }
            ret = Math.max(ret,dp[n]);
        }
        System.out.println(ret);
    }
}
