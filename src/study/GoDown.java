package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoDown {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j]= Integer.parseInt(split[j]);
            }
        }
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];
        maxDp[0][0] = map[0][0];minDp[0][0] = map[0][0];
        maxDp[0][1] = map[0][1];minDp[0][1] = map[0][1];
        maxDp[0][2] = map[0][2];minDp[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) { minDp[i][j] = Integer.MAX_VALUE/2; }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < 3; x++) {
                if(x!=0 && isRange(y+1,x-1)){
                    maxDp[y+1][x-1] = Math.max(maxDp[y][x]+map[y+1][x-1],maxDp[y+1][x-1]);
                    minDp[y+1][x-1] = Math.min(minDp[y][x]+map[y+1][x-1],minDp[y+1][x-1]);
                }
                if(x!=2 && isRange(y+1,x+1)){
                    maxDp[y+1][x+1] = Math.max(maxDp[y][x]+map[y+1][x+1],maxDp[y+1][x+1]);
                    minDp[y+1][x+1] = Math.min(minDp[y][x]+map[y+1][x+1],minDp[y+1][x+1]);
                }
                if(isRange(y+1,x)){
                    maxDp[y+1][x] = Math.max(maxDp[y][x]+map[y+1][x], maxDp[y+1][x]);
                    minDp[y+1][x] = Math.min(minDp[y][x]+map[y+1][x], minDp[y+1][x]);
                }
            }
        }
        System.out.print(Math.max(Math.max(maxDp[N-1][0],maxDp[N-1][1]),maxDp[N-1][2])+" ");
        System.out.println(Math.min(Math.min(minDp[N-1][0],minDp[N-1][1]),minDp[N-1][2]));
    }
    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<= x && x<3; }
}
