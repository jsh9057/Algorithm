package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NormalBag {
//    4 7
//6 13
//4 8
//3 6
//5 12
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for (int i = 1; i < N; i++) {
            split = br.readLine().split(" ");
            W[i]=Integer.parseInt(split[0]);
            V[i]=Integer.parseInt(split[1]);
        }

        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i < N; i++) {
            for (int w = 0; w <= K; w++) {
                if(w<W[i]){ dp[i][w]=dp[i-1][w]; }
                else{
                    dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-W[i]]+V[i]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println("i:"+i);
            for (int j = 0; j <= K; j++) {
                System.out.printf("dp[%d][%d] = %d\n",i,j,dp[i][j]);
            }
            System.out.println("-------");
        }
        System.out.println(dp[N-1][K]);
    }
}
