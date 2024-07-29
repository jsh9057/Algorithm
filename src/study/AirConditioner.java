package study;
public class AirConditioner {
    static int[][] dp;
    public static int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature+=40;
        t1+=40; t2+=40;

        dp = new int[1000][600];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 600; j++) { dp[i][j]=Integer.MAX_VALUE/2; }
        }

        dp[0][temperature] = 0;
        for (int i = 1; i < onboard.length; i++) {
            for (int j = 1; j < 91; j++) {
                if(onboard[i]==1 && (t1>j|| j>t2)){ continue; }

                if(temperature>j){ // 밖이 더 더울때
                    // 1도 올리려면 공짜
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]);
                    // 1도 내릴려면 a
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j+1]+a);
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+b);
                }
                else if(temperature<j){ // 밖이 더 시원할때
                    // 1도 올리려면 a
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+a);
                    // 1도 내릴려면 공짜
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j+1]);
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+b);
                }
                else{   // 밖이랑 안이랑 같을때
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]);
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j+1]);
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]);
                }
            }
        }
        int last= 0;
        int answer = Integer.MAX_VALUE/2;
        for (int i = 0; i < onboard.length; i++) { if(onboard[i]==1){last=i;} }
        for (int i = t1; i <=t2 ; i++) {
            System.out.println((i-40)+"도: "+dp[last][i]);
            answer = Math.min(answer,dp[last][i]);
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        solution(28	,18,	26,	10,	8,new int[]{0, 0, 1, 1, 1, 1, 1});
        solution(-10	,-5,	5,	5,	1,new int[]{0, 0, 0, 0, 0, 1, 0});
        solution(11,	8,	10,	10,	1,new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1});
        solution(11	,8	,10	,10	,100,new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1});
        solution(9, 7, 8, 10, 100,new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
    }
}
