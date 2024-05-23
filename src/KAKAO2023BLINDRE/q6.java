package KAKAO2023BLINDRE;

public class q6 {
    static final String[] dir = {"d","l","r","u"};
    static final int[] dx = {1,0,0,-1};
    static final int[] dy = {0,-1,1,0};
    static int endX,endY;
    static int N,M;
    static boolean[][][] visit;
    static boolean flag;
    static String answer = "impossible";

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        visit = new boolean[n+1][m+1][k+1];
        N = n; M=m;
        endX=r; endY=c;
        flag = false;

        int total =  Math.abs(x-r) + Math.abs(y-c);

        if(total > k){ return answer; }
        if((k - total)%2==1){ return answer; }
        dfs(x,y,k,"");
        return answer;
    }

    static void dfs(int x, int y, int k, String road) {
        if(flag){ return; }
        if(endX == x && endY == y && k==0 ){
            flag = true;
            answer = road;
        }
        visit[x][y][k] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<nx && nx<=N && 0<ny && ny<=M && k>0){
                if(visit[nx][ny][k-1]){ continue; }
                dfs(nx,ny,k-1,road+dir[i]);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));

        //"dllrl"
//        System.out.println(solution(2, 2, 1, 1, 2, 2, 2));
        //"dr"
//        System.out.println(solution(3, 3, 1, 2, 3, 3, 4));

        //"impossible"
        System.out.println(solution(6, 6, 2, 6, 6, 5, 11));
        //ddddllllrrr
    }
}
