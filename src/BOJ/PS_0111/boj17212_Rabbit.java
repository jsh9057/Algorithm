package BOJ.PS_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    최소한의 동전 갯수를 구하는 문제입니다.
    dp[N] : N 을 만드는데 필요한 최소 동전 갯수

    동전 종류  1,2,5,7

    dp[1] = 1 : 1원 x1
    dp[2] = 1 : 2원 x1
    dp[3] = 2 : 1원 x1 + 2원 x1   -> min(dp[3-2]+dp[2], dp[3-1]+dp[1])
    dp[4] = 2 : 2원 x2   -> min(dp[4-1]+dp[1], dp[2-2]+dp[2])
    dp[5] = 1 : 1원 x1
    dp[6] = 2 : 1원 x1 + 5원 x1   -> min(dp[6-5]+dp[5], dp[6-2]+dp[2], dp[6-1]+dp[1] )
    dp[7] = 1 : 7원 x1

    점화식
    dp[n] = Min(dp[n-1]+dp[1]
                ,dp[n-2]+dp[2]
                ,dp[n-5]+dp[5]
                ,dp[n-7]+dp[7] )

    +
    coin 배열을 만들어 반복문으로 점화식을 축소하였습니다.

 */

public class boj17212_Rabbit {
    static final int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[100001];
        int[] coin = {1,2,5,7};
        int N = Integer.parseInt(br.readLine());
        // 1,2,5,7
        dp[1]=1; dp[2]=1; dp[3]=2; dp[4]=2; dp[5]=1; dp[6]=2; dp[7]=1;
        for(int i=8;i<=N; i++){
            int min =MAX;
            for(int k=0;k<4;k++){
                min = Math.min(min,dp[i-coin[k]]+dp[coin[k]]);
            }
            dp[i]=min;
        }
        System.out.println(dp[N]);
    }
}
