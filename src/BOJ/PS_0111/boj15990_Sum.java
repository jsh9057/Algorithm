package BOJ.PS_0111;

/*
    1,2,3 더하기 5

    아이디어
    같은 수를 두 번 이상 연속해서 사용하면 안되기 때문에 마지막 숫자를 알아야 할 필요가 있습니다.
    마지막으로 숫자로 나올수 있는경우는 3개입니다.

    1로 끝나는 경우 에는 2,3 만 뒤에 붙일 수 있고
    2로 끝나는 경우 에는 1,3 만 뒤에 붙일 수 있고
    3로 끝나는 경우 에는 1,2 만 뒤에 붙일 수 있습니다.

    점화식
    dp[n][k] = n 을 만드는 수자의 합 중 마지막 숫자가 k 경우
    k 는 1~3 만 올 수 있습니다.

    즉
    dp[n][1] = dp[n-1][2] + dp[n-1][3]
    dp[n][2] = dp[n-2][1] + dp[n-2][3]
    dp[n][3] = dp[n-3][1] + dp[n-3][2]

    +
    마지막에 출력할때 dp[n][1]+dp[n][2]+dp[n][3]
    나머지 연산을 한 번 더 해야합니다.. 이유는 더하는 과정에서 숫자가 너무 커질 수 있기때문에

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15990_Sum {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        long[][] dp = new long[100001][4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] test = new int[T];
        int max = 0;
        for(int t=0; t<T; t++){
            int in = Integer.parseInt(br.readLine());
            test[t]= in;
            max = Math.max(max, in);
        }
        dp[1][1]= 1; dp[2][2]= 1; dp[3][1]= 1; dp[3][2]= 1; dp[3][3]= 1;

        for(int n=4;n<=max;n++){
            dp[n][1] = (dp[n-1][2] + dp[n-1][3])%MOD;
            dp[n][2] = (dp[n-2][1] + dp[n-2][3])%MOD;
            dp[n][3] = (dp[n-3][1] + dp[n-3][2])%MOD;
        }

        for(int t=0;t<T;t++){
            sb.append((dp[test[t]][1]+dp[test[t]][2]+dp[test[t]][3])%MOD).append("\n");
        }
        System.out.println(sb);
    }
}
