package Dynamic;

public class Travel {
    public static void main(String args[]){
        int K = 1650;
        // 도보이동 시간, 도보 모금액, 자전거이동 시간, 자전거 모금액
        int[][] travel = {{500,200,200,100},{800,370,300,120},
                {700,250,300,90}};

        int size = travel.length;
        int[][] dp = new int [size+1][100001];
        //dp[i번째 도시][시간]
        //dp[0번째][도보시간]=도보 모금액
        dp[0][travel[0][0]]=travel[0][1];
        //dp[0번째][자전거시간]=자전거 모금액
        dp[0][travel[0][2]]=travel[0][3];

        int maxMoney=0;
        for(int i=1; i<size; i++){
            for(int j=0; j<=K; j++){
                if(dp[i-1][j]==0) {continue;}
                //도보 계산
                if(j+travel[i][0]<=K){
                    dp[i][j+travel[i][0]]=Math.max(dp[i][j+travel[i][0]],dp[i-1][j]+travel[i][1]);
                    maxMoney = Math.max(maxMoney,dp[i][j+travel[i][0]]);
                }
                //자전거 계산
                if(j+travel[i][2]<=K){
                    dp[i][j+travel[i][2]]=Math.max(dp[i][j+travel[i][2]],dp[i-1][j]+travel[i][3]);
                    maxMoney = Math.max(maxMoney,dp[i][j+travel[i][2]]);
                }
            }
        }
        System.out.println(maxMoney);
    }
}
