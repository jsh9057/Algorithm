package BOJ.PS_0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    피보나치를 재귀로 작성했을 때 특성상 반복되는 계산을 계속 하게됩니다.
    fib(2) = fib(1)+fib(0)
    fib(3) = fib(2)+fib(1)  : fib(2),fib(1) 중복계산
    fib(4) = fib(3)+fib(2)  : fib(3),fib(2) 중복계산
    ..
    fib(n) = fib(n-2)+fib(n-1)

    점화식
    dp[n] : n 을 만드는데 호출된 횟수
    dp[n] = dp[n-1] + dp[n-2] + 1   : +1을 하는 이유는 n 자체도 1회 호출하기 떄문


 */

public class boj17175_Fib {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        long[] dp = new long[51];
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[0]=1; dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1] +dp[i-2]+1)%MOD;
        }
        System.out.println(dp[n]);
    }
}
