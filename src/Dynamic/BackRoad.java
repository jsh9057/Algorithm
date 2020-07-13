package Dynamic;

public class BackRoad {
    static final int MOD = 1000000007;
    public static void main(String args[]){
        int m = 4;
        int n = 3;
//        int[][] puddles = {{3,3},{4,2}};
        int[][] puddles = {{1,2},{3,1}};
        int[][] dp = new int [n][m];
        boolean[][] water = new boolean[n][m];
        for(int i=0; i<puddles.length; i++){
            water[puddles[i][1]-1][puddles[i][0]-1]=true;
        }
        for(int i=0; i<n; i++){if(water[i][0]==true){break;} dp[i][0]=1;}
        for(int i=0; i<m; i++){if(water[0][i]==true){break;} dp[0][i]=1;}
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(!water[i][j]){dp[i][j]=(dp[i][j-1]+dp[i-1][j])%MOD;}
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        System.out.println(dp[n-1][m-1]);
    }
}
