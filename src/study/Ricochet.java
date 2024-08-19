package study;

import java.util.LinkedList;
import java.util.Queue;

public class Ricochet {
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N,M;
    public static int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new int[N][M];
        int startY=0,startX=0;
        int goalY=0,goalX=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i].charAt(j)=='.'){ continue; }
                else if(board[i].charAt(j)=='D'){ map[i][j]=1; }
                else if(board[i].charAt(j)=='R'){ startY = i ; startX=j; }
                else{ goalY=i; goalX=j; }
            }
        }

        boolean[][] visit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY,startX,0});
        visit[startY][startX]=true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0]==goalY && now[1]==goalX){ System.out.println(now[2]); return now[2];}

            for (int i = 0; i < 4; i++) {
                int[] next = go(now[0],now[1],i);
                if(!visit[next[0]][next[1]]){
                    visit[next[0]][next[1]]=true;
                    queue.add(new int[]{next[0],next[1],now[2]+1});
                }
            }
        }
        System.out.println(-1);
        return -1;
    }
    static int[] go(int y, int x, int dir){
        while (true){
            if(!isRange(y+dy[dir],x+dx[dir]) || map[y+dy[dir]][x+dx[dir]]==1){ break; }
            y += dy[dir];
            x += dx[dir];
        }
        return new int[]{y,x};
    }
    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<=x && x<M; }
    public static void main(String[] args) {
        solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        solution(new String[]{".D.R", "....", ".G..", "...D"});
    }
}
