package 릿코드;

public class Q2684 {
    static final int[] dx ={1,1,1};
    static final int[] dy ={-1,0,1};
    static boolean[][] visit;
    static int max;
    static int N;
    static int M;
    public int maxMoves(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        max = 0;
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            dfs(grid,i,0, 0);
        }
        return max;
    }

    void dfs(int[][] grid , int y, int x, int dept){
        if(visit[y][x]){ return; }
        if(max<dept){ max = dept; }

        for (int i = 0; i < 3; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(isRange(ny,nx) && grid[y][x]<grid[ny][nx]){
                visit[ny][nx]=true;
                dfs(grid,ny,nx,dept+1);
            }
        }
    }
    boolean isRange(int y, int x){ return 0<=y && y<N && 0<=x && x<M; }

}
