package 소프트티어;
import java.io.*;
import java.util.*;

public class q6246 {
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int N;
    static int M;
    static int ret;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][N];
        for(int i=0; i<N;i++){
            split = br.readLine().split(" ");
            for(int j=0; j<N;j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[][] must = new int[M][2];
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            must[i][0] = Integer.parseInt(split[0])-1;
            must[i][1] = Integer.parseInt(split[1])-1;
        }
        boolean[][] visit = new boolean[N][N];
        ArrayList<ArrayList<Integer>> record = new ArrayList<>();

        ret = 0;
        visit[must[0][0]][must[0][1]]=true;
        ArrayList<Integer> xy = new ArrayList<>();
        xy.add(must[0][0]);
        xy.add(must[0][1]);
        record.add(xy);
        bt(must[0][0], must[0][1], must[M-1][0], must[M-1][1], visit, must,record);
        System.out.println(ret);
    }

    static void bt(int y, int x, int ty, int tx, boolean[][] visit, int[][] must, ArrayList<ArrayList<Integer>> record){
        if(y == ty && x==tx){
            int idx = 0;
            for(ArrayList<Integer> xy : record){
                if(must[idx][0]== xy.get(0) && must[idx][1]==xy.get(1)){ idx++; }
            }
            if(idx==M){
                ret++;
            }

            // must (2,0) (0,2) (1,2)
            // for(ArrayList<Integer> xy: record){
            //     System.out.println(xy);
            // }
            // System.out.println("------------------------------");

            return;
        }
        // visit[y][x] = true;

        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(isRange(ny,nx) && map[ny][nx]==0 && !visit[ny][nx]){
                visit[ny][nx]=true;
                ArrayList<Integer> xy = new ArrayList<>();
                xy.add(ny);
                xy.add(nx);
                record.add(xy);
                bt(ny, nx, ty, tx,visit,must,record);
                record.remove(record.size()-1);
                visit[ny][nx]=false;
            }
        }
    }

    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<=x && x<N; }
}
