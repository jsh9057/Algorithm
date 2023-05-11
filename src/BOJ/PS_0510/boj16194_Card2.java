package BOJ.PS_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    저번에 풀었던 문제 유형이라 접근법이 쉽게 떠올랐습니다.
    dp[i] : i장의 카드를 살 때, 최소비용

    dp[1] = arr[1]
    dp[2] = arr[2] vs (dp[1] + dp[1])   : dp[1] 은 1장의 카드를 살 때 최소비용이므로
    dp[3] = arr[3] vs (dp[1] + dp[2])
    dp[4] = arr[4] vs (dp[1] + dp[3])
                      (dp[2] + dp[2])
    ...
    .

    점화식
    dp[i] = Min( dp[i], dp[i-k]+dp[k] )

 */

public class boj16194_Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        int[] dp = new int[1001];

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {arr[i]=Integer.parseInt(input[i-1]);}

        for (int i = 1; i <= N; i++) {
            dp[i]=arr[i];
            for (int j = 1; j < i; j++) {
                dp[i]=Math.min(dp[i],dp[i-j]+dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
