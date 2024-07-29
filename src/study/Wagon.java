package study;

import java.util.LinkedList;
import java.util.Queue;

public class Wagon {
    static final int RED = 1;
    static final int BLUE = 2;
    static final int RED_GOAL=3;
    static final int BLUE_GOAL=4;
    static final int WALL = 5;
    static int N,M;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    public static int solution(int[][] maze) {
        int answer = 0;
        N = maze.length;
        M = maze[0].length;

        int redY=0,redX=0;
        int blueY=0,blueX=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(maze[i][j]==RED){ redY=i; redX=j; };
                if(maze[i][j]==BLUE){ blueY=i; blueX=j; }
            }
        }

        boolean[][] redVisit = new boolean[N][M];
        boolean[][] blueVisit = new boolean[N][M];

        maze[redY][redX]=0;
        maze[blueY][blueX]=0;
        Queue<State> q = new LinkedList<>();
        q.add(new State(redY,redX,blueY,blueX,redVisit,blueVisit,0));

        while (!q.isEmpty()){
            State now = q.poll();
            boolean redEnd = false;
            boolean blueEnd = false;
            if(maze[now.redY][now.redX]==RED_GOAL){ redEnd=true; }
            if(maze[now.blueY][now.blueX]==BLUE_GOAL){ blueEnd=true; }
            if(redEnd && blueEnd){ System.out.println(now.turn); return now.turn; }

            now.redVisit[now.redY][now.redX] = true;
            now.blueVisit[now.blueY][now.blueX]= true;
            if(redEnd){ now.redVisit[now.redY][now.redX]=false; }
            if(blueEnd){ now.blueVisit[now.blueY][now.blueX]=false; }

            for (int i = 0; i < 4; i++) {
                int redNY = now.redY + dy[i];
                int redNX = now.redX + dx[i];
                if(redEnd){ redNY = now.redY; redNX = now.redX; }
                for (int j = 0; j < 4; j++) {
                    int blueNY = now.blueY + dy[j];
                    int blueNX = now.blueX + dx[j];
                    if(blueEnd){ blueNY = now.blueY; blueNX = now.blueX; }
                    if((isRange(redNY,redNX) && isRange(blueNY,blueNX))     // 1. 범위
                        && (maze[redNY][redNX]!=WALL && maze[blueNY][blueNX]!=WALL)
                        && (!now.redVisit[redNY][redNX] && (!now.blueVisit[blueNY][blueNX]))    // 2. 방문
                        && !(redNY==blueNY&&redNX==blueNX)   // 3. 움직이고나서 둘이 겹치는 경우
                        && !((now.redY==blueNY&&now.redX==blueNX) && (now.blueY==redNY&&now.blueX==redNX))){ // 4. 둘이 자리를 바꾸는 경우
                        q.add(new State(redNY,redNX,blueNY,blueNX, deepCopy(now.redVisit),deepCopy(now.blueVisit),now.turn+1));
                    }
                }
            }
        }

        System.out.println(0);
        return 0;
    }
    static boolean[][] deepCopy(boolean[][] arr){
        boolean[][] ret = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { ret[i][j]=arr[i][j]; }
        }
        return ret;
    }
    static boolean isRange(int y, int x){ return 0<=y && y<N && 0 <=x && x<M; }

    static class State{
        int redY,redX;
        int blueY,blueX;
        boolean[][] redVisit;
        boolean[][] blueVisit;
        int turn;

        public State(int redY, int redX, int blueY, int blueX, boolean[][] redVisit, boolean[][] blueVisit, int turn) {
            this.redY = redY;
            this.redX = redX;
            this.blueY = blueY;
            this.blueX = blueX;
            this.redVisit = redVisit;
            this.blueVisit = blueVisit;
            this.turn = turn;
        }
    }
    public static void main(String[] args) {
        solution(new int[][]{{1, 4}, {0, 0}, {2, 3}});
        solution(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0 ,5}, {4, 0, 3}});
        solution(new int[][]{{1, 5}, {2, 5}, {4, 5}, {3, 5}});
        solution(new int[][]{{4, 1, 2, 3}});
    }
}
