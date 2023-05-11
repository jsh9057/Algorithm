package BOJ.PS_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    저번에 풀었던 문제의 이동방식과 비슷하여 쉽게 접근하였습니다.
    (오른쪽 아래로 이동하는 방식)

    메모리제이션을 사용하면 중복계산을 피할 수 있어 bfs 보다 효율적으로 계산할 수 있습니다.
    각 칸에서 움직일 수 있는 최대 거리는 map[i][j] 이며, 사용하지않은 부스터는 모두 사라집니다.

    dp[i][k] : (i,k) 까지 가는데 먹은 부스터의 횟수(!= 갯수)

    각 칸에서 이동할 수 모든칸에
    현재칸 (i,j) / K = 1 ~ 현재칸에서 먹은 부스터 갯수
    dp[i][j+k] = min(dp[i][j+k],dp[i][j]+1)
    dp[i+k][j] = min(dp[i+k][j],dp[i][j]+1)

    마지막에 N,M 에 도착할때도 부스터를 먹기때문에
    dp[N][M]-1 합니다.

 */

public class boj17391_Booster {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[301][301];
        int[][] dp = new int[301][301];

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i=1;i<=N;i++){
            input=br.readLine().split(" ");
            for(int j=1;j<=M;j++){
                map[i][j]=Integer.parseInt(input[j-1]);
            }
        }

        dp[1][1]=1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(dp[i][j]==0){continue;}
                int move = map[i][j];
                int now = dp[i][j];

                for (int k = 1; k <= move; k++) {
                    if(!isRange(i,j+k)){ continue; }
                    if(dp[i][j+k]==0){ dp[i][j+k] = now+1; continue;}
                    dp[i][j+k]=Math.min(dp[i][j+k],now+1);
                }
                for (int k = 1; k <= move; k++) {
                    if(!isRange(i+k,j)){ continue; }
                    if(dp[i+k][j]==0){ dp[i+k][j] = now+1; continue;}
                    dp[i+k][j]=Math.min(dp[i+k][j],now+1);
                }
            }
        }
        System.out.println(dp[N][M]-1);
    }
    static boolean isRange(int y,int x){
        return 1<=y && y<=N && 1<=x && x<=M;
    }
}
