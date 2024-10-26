package 플로이드워샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1719 {
    static int[][] graph;
    static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        graph = new int[N+1][N+1];
        path = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i==j){continue;}
                graph[i][j]=10000;
            }
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            graph[s][e] = c;
            graph[e][s] = c;
        }
        floyd(N);
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (path[i][j] != 0) {
                    int start = i;
                    int end = j;
                    while (path[start][end] != 0) {
                        end = path[start][end];
                    }
                    path[i][j] = end;
                }
            }
        }
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i == j){ System.out.print("- ");}
                else if(path[i][j]==0){ System.out.print(j+" "); }
                else{
                    System.out.print(path[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void floyd(int n) {
    		// 경유지
        for (int k = 1; k <= n; k++) {
            // 출발지
            for (int i = 1; i <= n; i++) {
                //도착지
                for (int j = 1; j <= n; j++) {
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j]=graph[i][k] + graph[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }
}
