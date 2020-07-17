package Dynamic;

public class Card {

    static int[][] dp;
    static boolean[][] visit;

    public static void main(String args[]){
        int[] left = {1,8,9,1,1,1,1};
        int[] right= {8,9,3,3,3,3,3};
        dp = new int[left.length][right.length];
        visit = new boolean[left.length][right.length];
        int answer = recur(0,0,left,right);
        System.out.println(answer );
    }

    static int recur(int l, int r, int[] left, int[] right){
        if(l == left.length || r== right.length) {
            return 0;
        }
        if(visit[l][r]==true){
            return dp[l][r];
        }
        dp[l][r] = Math.max(recur(l+1,r,left,right),recur(l+1,r+1,left,right));
        if(left[l] > right[r]){
            dp[l][r] = Math.max(dp[l][r],recur(l,r+1,left,right)+right[r]);
        }

        visit[l][r]=true;

        return dp[l][r];
    }
}
