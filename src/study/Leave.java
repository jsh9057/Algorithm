package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Leave {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            T[i]=Integer.parseInt(split[0]);
            P[i]=Integer.parseInt(split[1]);
        }

        int[] dp = new int[N+2];
        for (int i = N; i > 0; i--) {
            if(i+T[i]>N+1){ dp[i]=dp[i+1]; }
            else { dp[i]=Math.max(dp[T[i]+i]+P[i],dp[i+1]); }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[1]);
    }
}
