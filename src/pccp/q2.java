package pccp;

import java.util.*;

public class q2 {
    static int[][] map;
    static int[][] chunk;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int maxX;
    static int maxY;
    static HashMap<Integer,Integer> amount;
    public static int solution(int[][] land) {
        maxY = land.length;
        maxX = land[0].length;
        chunk = new int[maxY][maxX];
        map = new int[maxY][maxX];
        amount = new HashMap<>();

        for (int i = 0; i < maxY; i++) { map[i]=land[i]; }

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if(land[i][j]==0){ continue; }
                if(chunk[i][j]!=0){ continue; }
                chunk(i,j,(i*land[0].length)+j+1);
            }
        }
        if(amount.isEmpty()){return 0;}

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                System.out.printf("%3d",chunk[i][j]);
            }
            System.out.println();
        }
        int max = 0;
        for (int i = 0; i < maxX; i++) {
            HashSet<Integer> visitSet = visited(i);
            if(visitSet.isEmpty()){ continue; }
            List<Integer> list = new ArrayList<>(visitSet);
            int sum = 0;
            for (int l: list){ sum+=amount.getOrDefault(l,0); }
            max = Math.max(max,sum);
        }
        System.out.println(max);
        return max;
    }
    static void chunk(int y, int x, int id){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{y,x});
        while (!stack.isEmpty()){
            int[] dir = stack.pop();
            if(chunk[dir[0]][dir[1]]>0){ continue; }
            chunk[dir[0]][dir[1]]=id;
            amount.put(id,amount.getOrDefault(id,0)+1);
            for (int i = 0; i < 4; i++) {
                int ny = dir[0]+dy[i];
                int nx = dir[1]+dx[i];
                if(isRange(ny,nx) && map[ny][nx]==1 && chunk[ny][nx]==0){ stack.add(new int[]{ny,nx}); }
            }
        }
    }

    static HashSet<Integer> visited(int x){
        HashSet<Integer> ret = new HashSet<>();
        for (int i = 0; i < maxY; i++) {
            if(chunk[i][x]==0){continue;}
            ret.add(chunk[i][x]);
        }
        return ret;
    }
    static boolean isRange(int y, int x){ return 0<=y && y<maxY && 0<=x&& x<maxX; }

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
        solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}});
    }
}
