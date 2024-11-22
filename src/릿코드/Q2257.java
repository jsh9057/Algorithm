package 릿코드;

public class Q2257 {
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] visit = new boolean[m][n];
        int[][] map = new int[m][n];

        for(int[] g: guards){
            visit[g[0]][g[1]]=true;
            map[g[0]][g[1]]=1;
        }
        for(int[] w: walls){
            visit[w[0]][w[1]]=true;
            map[w[0]][w[1]]=2;
        }
        setGuard(map,visit,guards,m,n);

        int ret = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){ ret++; }
            }
        }
        return ret;
    }

    void setGuard(int[][] map ,boolean[][] visit, int[][] guards,int m, int n){
        for(int[] g : guards){
            for(int i=0;i<4;i++){
                int ny = g[0]+ dy[i];
                int nx = g[1]+ dx[i];
                while(isRange(ny,nx,m,n) && map[ny][nx]==0){
                    visit[ny][nx]=true;
                    ny += dy[i];
                    nx += dx[i];
                }
            }
        }
    }
    boolean isRange(int y, int x, int m, int n){ return 0<=y&& y<m && 0<=x&& x<n; }
}
