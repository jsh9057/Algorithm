package Dynamic;
//level 4

public class Thievery {
    public static void main(String[] args){
        int[] money = {1,2,3,1};
        int[] dp = new int[money.length];
        dp[1]=money[1];
        dp[2]=money[2];
        int dp1Max=0;
        for(int i=2; i<money.length; i++){
            if(i==2){dp1Max=Math.max(dp1Max,dp[i]); continue;}
            if(i==money.length-1){
                dp[i]=Math.max((dp[i-3]-dp[0]),dp[i-2])+money[i];
            }else{
                dp[i]=Math.max(dp[i-3],dp[i-2])+money[i];
            }
            dp1Max=Math.max(dp1Max,dp[i]);
        }
        for(int n: dp)
            System.out.print(n+" ");

        System.out.println("");
        dp = new int[money.length];
        dp[0]=money[0];
        dp[1]=money[1];
        dp[2]=money[2]+dp[0];
        int dp2Max=0;
        for(int i=2; i<money.length-1; i++){
            if(i==2){dp2Max=Math.max(dp2Max,dp[i]); continue;}
            dp[i]=Math.max(dp[i-3],dp[i-2])+money[i];
            dp2Max=Math.max(dp2Max,dp[i]);
        }
        for(int n: dp)
            System.out.print(n+" ");
        System.out.println();
        System.out.println(Math.max(dp1Max,dp2Max));
    }
}
