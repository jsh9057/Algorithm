package KAKAO2022BLINDREC;

import java.util.ArrayList;
import java.util.List;

public class q5 {
    static int maxSheep;
    static ArrayList<Integer>[] tree;
    static int[] treeInfo;
    public static int solution(int[] info, int[][] edges) {
        maxSheep = 0;
        tree = new ArrayList[info.length];
        treeInfo = info;

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if(tree[from]==null){tree[from]=new ArrayList<>();}
            tree[from].add(to);
        }

        dfs(0,new ArrayList<>(),1,0);
        System.out.println(maxSheep);
        return maxSheep;
    }

    static void dfs(int now, List<Integer> nextVisit, int sheep, int wolf) {
        maxSheep = Math.max(sheep,maxSheep);
        System.out.println("node:"+now);

        List<Integer> newVisit = new ArrayList<>(nextVisit);
        if(tree[now]!=null){ newVisit.addAll(tree[now]); }
        newVisit.remove((Object)now);
        System.out.println("sheep:"+sheep+" wolf:"+wolf);
        System.out.println(newVisit.toString());


        for(Integer next : newVisit){
            if(sheep > treeInfo[next]+wolf) {
                if(treeInfo[next]==0){
                    dfs(next, newVisit, sheep+1, wolf);
                }else {
                    dfs(next, newVisit, sheep, wolf+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
//        solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}});
    }
}