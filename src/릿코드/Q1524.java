package 릿코드;

public class Q1524 {
    public int numOfSubarrays(int[] arr) {
        int[][] dp = new int[arr.length][2]; // dp[n][0]:even / dp[n][1]:odd
        dp[0][0] = arr[0]%2==0 ? 1:0;
        dp[0][1] = arr[0]%2==0 ? 0:1;
        int MOD = 1000000007;
        int res = dp[0][1];

        for(int i=1;i<arr.length;i++){
            if(arr[i]%2==0){    // even
                dp[i][0]=(dp[i-1][0]+1)%MOD;
                dp[i][1]=dp[i-1][1];
            }else{              // odd
                dp[i][0]=dp[i-1][1];
                dp[i][1]=(dp[i-1][0]+1)%MOD;
            }
            res = (res+dp[i][1])%MOD;
        }
        return res;
    }
}
