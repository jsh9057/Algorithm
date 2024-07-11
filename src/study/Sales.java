package study;

import java.util.ArrayList;

public class Sales {
    static Node[] nodes;
    static int[][] dp;
    public static int solution(int[] sales, int[][] links) {
        nodes = new Node[sales.length+1];
        dp = new int[sales.length+1][2];

        for (int i = 0; i < sales.length; i++) { nodes[i+1]=new Node(i+1,sales[i]); }
        for (int i = 0; i < links.length; i++) {
            int from = links[i][0];
            int to = links[i][1];
            nodes[from].addChild(nodes[to]);
        }
        dfs(1);
        return Math.min(dp[1][0],dp[1][1]);
    }

    static void dfs(int now){
        dp[now][0]=0;
        dp[now][1]=nodes[now].cost;
        if(!nodes[now].isLeader){ return; }

        int min = Integer.MAX_VALUE;

        for (Node next : nodes[now].child){
            dfs(next.n);
            if(dp[next.n][0]<dp[next.n][1]){
                dp[now][0] += dp[next.n][0];    // 팀장 x, 팀원 x
                dp[now][1] += dp[next.n][0];    // 팀장 o, 팀원 x
                min = Math.min(min, dp[next.n][1]-dp[next.n][0]);
            }
            else{
                dp[now][0] += dp[next.n][1];    // 팀장 x, 팀원 o
                dp[now][1] += dp[next.n][1];    // 팀장 o, 팀원 o
                min = 0;
            }
        }
        dp[now][0]+=min;
    }
    public static void main(String[] args) {
        solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}});
        solution(new int[]{5, 6, 5, 3, 4},new int[][]{{2,3}, {1,4}, {2,5}, {1,2}});
        solution(new int[]{5, 6, 5, 1, 4},new int[][]{{2,3}, {1,4}, {2,5}, {1,2}});
        solution(new int[]{10, 10, 1, 1},new int[][]{{3,2}, {4,3}, {1,4}});
    }

    static class Node {
        int n;
        int cost;
        boolean isLeader;
        ArrayList<Node> child;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
            isLeader = false;
            child = new ArrayList<>();
        }

        public void addChild(Node child){ this.child.add(child); isLeader = true; }
    }
}
