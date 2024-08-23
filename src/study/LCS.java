package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int[][] dp = new int[a.length+1][b.length+1];
        int ret = 0;
        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if(i == 0 || j == 0){ continue; }
                if(a[i-1]==b[j-1]){ dp[i][j]=dp[i-1][j-1]+1; }
                else{ dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]); }
                ret = Math.max(dp[i][j],ret);
            }
        }
        System.out.println(ret);
    }
}
