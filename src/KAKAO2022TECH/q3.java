package KAKAO2022TECH;

public class q3 {
    public static int solution(int alp, int cop, int[][] problems) {
        int[][] dp = new int[152][152];

        for (int i = alp; i < 152; i++) {
            for (int j = cop; j < 152; j++) {
                dp[i][j]=i-alp+j-cop;
            }
        }

        int alp_target = alp;
        int cop_target = cop;

        for (int[] p : problems){
            alp_target = Math.max(p[0],alp_target);
            cop_target = Math.max(p[1],cop_target);
        }

        for (int al = alp; al <= alp_target; al++) {
            for (int co = cop; co <= cop_target; co++) {
                dp[al+1][co]=Math.min(dp[al][co]+1,dp[al+1][co]);
                dp[al][co+1]=Math.min(dp[al][co]+1,dp[al][co+1]);

                for (int p = 0; p < problems.length; p++) {
                    int alp_req = problems[p][0];
                    int cop_req = problems[p][1];
                    if(al>=alp_req && co>=cop_req){
                        int nxt_alp = al+problems[p][2];
                        int nxt_cop = co+problems[p][3];
                        int nxt_cost = dp[al][co]+problems[p][4];
                        nxt_alp=Math.min(nxt_alp,alp_target);
                        nxt_cop=Math.min(nxt_cop,cop_target);

                        dp[nxt_alp][nxt_cop] = Math.min(dp[nxt_alp][nxt_cop],nxt_cost);
                    }
                }
            }
        }
        System.out.println(dp[alp_target][cop_target]);
        return dp[alp_target][cop_target];
    }
    public static void main(String[] args) {
        solution(10, 10, new int[][]{{10,15,2,1,2},{20,20,3,3,4}});
        solution(0,0, new int[][]{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
    }
}