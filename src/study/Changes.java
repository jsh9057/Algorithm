package study;

import java.util.Arrays;

public class Changes {
    public static int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);
        int[] dp = new int[n+1];
        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                if(j==money[i]){ dp[j]+=1; }
                dp[j]+=dp[j-money[i]];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(10,new int[]	{2,4,6,8});
    }
}
