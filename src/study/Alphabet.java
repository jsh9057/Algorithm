package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet {
    static final int[] dr = {0,0,1,-1};
    static final int[] dc = {1,-1,0,0};
    static int R;
    static int C;
    static char[][] map;
    static boolean[] visit;
    static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        map = new char[R][C];
        visit = new boolean[26];
        for (int i = 0; i < R; i++) {
            String in = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j]=in.charAt(j);
            }
        }
        dfs(0,0,1);
        System.out.println(maxDepth);
    }

    static void dfs(int r, int c, int depth){
        char now = map[r][c];
        if(visit[now-'A']){ return; }
        visit[now-'A']=true;
        if(depth > maxDepth ){ maxDepth = depth; }

        for (int i = 0; i < 4; i++) {
            int nr = dr[i]+r;
            int nc = dc[i]+c;
            if(isRange(nr,nc)){
                char nextChar = map[nr][nc];
                if(!visit[nextChar-'A']){
                    dfs(nr,nc,depth+1);
                    visit[nextChar-'A']=false;
                }
            }
        }
    }

    static boolean isRange(int r, int c){ return 0<=r&&r<R && 0<=c&& c<C; }
}
