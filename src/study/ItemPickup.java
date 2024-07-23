package study;

import java.util.LinkedList;
import java.util.Queue;

public class ItemPickup {
    static int[][] map;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy={0,0,1,-1};
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        for (int[] r: rectangle){ draw(r);}
        for (int[] r: rectangle){ draw2(r);}

        boolean[][] visit = new boolean[102][102];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY*2, characterX*2,0});
        visit[characterY*2][characterX*2]=true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==itemY*2 && now[1]==itemX*2){
                System.out.println(now[2]/2);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i]+now[0];
                int nx = dx[i]+now[1];
                if(map[ny][nx]==1 && !visit[ny][nx]){
                    q.add(new int[]{ny,nx,now[2]+1});
                    visit[ny][nx]=true;
                }
            }
        }
        return -1;
    }

    static void draw (int[] rectangle){
        int x1=rectangle[0]*2; int y1=rectangle[1]*2; int x2=rectangle[2]*2; int y2=rectangle[3]*2;
        for (int i = x1; i <= x2; i++) {
            map[y1][i]=1;
            map[y2][i]=1;
        }
        for (int i = y1; i <= y2; i++) {
            map[i][x1]=1;
            map[i][x2]=1;
        }
    }
    static void draw2 (int[] rectangle){
        int x1=rectangle[0]*2+1; int y1=rectangle[1]*2+1; int x2=rectangle[2]*2-1; int y2=rectangle[3]*2-1;
        for (int i = y1; i <=y2 ; i++) {
            for (int j = x1; j <=x2 ; j++) {
                map[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8);
        solution(new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},9,7,6,1);
        solution(new int[][]{{1,1,5,7}},1,1,4,7);
        solution(new int[][]{{2,1,7,5},{6,4,10,10}},3,1,7,10);
        solution(new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}},1,4,6,3);
    }
}