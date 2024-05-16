package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1520 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M;
    static int N;
    static int[][] map;
    static int[][] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); // 세로
        N = Integer.parseInt(input[1]); // 가로
        visited = new int[M][N];
        answer = 0;

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                visited[i][j]=-1;
            }
        }

        System.out.println(dfs(0, 0));
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(visited[i][j] +" ");
            }
            System.out.println();
        }
    }

    static int dfs(int x, int y) {

        if(x ==  N-1 && y == M-1){ return 1; }

        if(visited[y][x]!=-1){ return visited[y][x];}

        visited[y][x]=0;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny) && map[ny][nx] < map[y][x]){
                visited[y][x] += dfs(nx,ny);
            }
        }
        return visited[y][x];
    }

    static boolean isRange(int x, int y){ return 0<=x && x<N && 0<=y && y<M; }
}
