package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class City {
    static final int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] d = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i==j){continue;}
                d[i][j]=INF;
            }
        }

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);
            d[start][end]=Math.min(cost,d[start][end]);
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    if(d[j][i]+d[i][k]<d[j][k]){
                        d[j][k] = d[j][i] + d[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                sb.append(d[i][j]==INF? 0:d[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
