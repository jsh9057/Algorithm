package BOJ.PS_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1720_TileCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[31];
        int N = Integer.parseInt(br.readLine());

        if(N==1){System.out.println(1); return;}
        dp[1]=1;
        dp[2]=3;
        for(int i=3 ; i <= N ; i++){
            dp[i]= dp[i-1] + (dp[i-2])*2;
        }
        int ret;
        if(N%2==1){
            ret = (dp[N]+dp[N/2])/2;
        }
        else{
            ret = (dp[N]+dp[N/2+1])/2;
        }
        System.out.println(ret);
    }
}
