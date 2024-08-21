package study;

public class Pulse {
    public static long solution(int[] sequence) {
        long answer = 0;
        long[][] dp = new long[sequence.length][2];
        dp[0][0]=-sequence[0];
        dp[0][1]=sequence[0];
        answer = Math.max(dp[0][0],dp[0][1]);
        for (int i = 1; i < sequence.length; i++) {
            dp[i][0]=Math.max(-sequence[i],dp[i-1][1]-sequence[i]);
//            System.out.printf("-s[%d]:%d vs dp[%d][1]-s[%d]:%d \n",i,-sequence[i],i-1,i,dp[i-1][1]-sequence[i]);
            dp[i][1]=Math.max(sequence[i],dp[i-1][0]+sequence[i]);
//            System.out.printf("s[%d]:%d vs dp[%d][1]+s[%d]:%d \n",i,sequence[i],i-1,i,dp[i-1][0]+sequence[i]);
            answer = Math.max(answer,dp[i][0]);
            answer = Math.max(answer,dp[i][1]);
        }
        System.out.println(answer);

        return answer;
    }
    public static void main(String[] args) {
        solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4});
    }
}
