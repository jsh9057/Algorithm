package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElectricWire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[501];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            arr[a] = b;
            maxLen = Math.max(maxLen,a);
            maxLen = Math.max(maxLen,b);
        }
        int[] dp = new int[501];
        int max = -1;
        for (int n = 0; n <= maxLen; n++) {
            if(arr[n]==0){continue;}
            dp[n] = 1;
            for (int k = 0; k < n; k++) {
                if(arr[n]>arr[k]){
                    dp[n] = Math.max(dp[n],dp[k]+1);
                }
            }
            max = Math.max(max,dp[n]);
        }
        System.out.println(N-max);
    }
}
