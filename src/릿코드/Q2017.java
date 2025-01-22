package 릿코드;

public class Q2017 {
    public long gridGame(int[][] grid) {
        int N = grid[0].length;
        long a = 0;
        long b = 0;
        for(int i=0; i<N; i++){
            a += grid[0][i];
        }

        long ret = Long.MAX_VALUE;
        for(int i=0; i<N; i++){
            a -= (long) grid[0][i];
            ret = Math.min(ret, Math.max(a,b));
            b += (long) grid[1][i];
        }
        return ret;
    }
}
