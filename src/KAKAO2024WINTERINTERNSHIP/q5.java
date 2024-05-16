package KAKAO2024WINTERINTERNSHIP;

public class q5 {
    static int[][] dp;

    static final int MOD = 10007;
    public static int solution(int n, int[] tops) {
        int answer = 0;
        dp = new int[n+1][2];
        dp[0][0]=1;
        dp[0][1]=0;

        for(int i=0; i<n; i++){
            int k = i+1;
            dp[k][1]=(dp[i][0] + dp[i][1])%MOD;
            if(tops[i]==0){
                dp[k][0] = (dp[i][0]*2 + dp[i][1])%MOD;
            }
            else {
                dp[k][0] = (dp[i][0]*3 + dp[i][1]*2)%MOD;
            }
        }
        System.out.println((dp[n][0]+dp[n][1])%MOD);
        return answer;
    }
    public static void main(String[] args) {
        solution(4, new int[] {1, 1, 0, 1});
        solution(2, new int[] {0, 1});
        solution(10, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
}