package 릿코드;
import java.util.*;

public class Q2467 {
    private HashMap<Integer, Integer> bobPath;
    private boolean[] visit;
    private ArrayList<Integer>[] nodes;
    private int maxCost;
    private int bobMaxDepth;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        nodes = new ArrayList[amount.length];
        bobPath = new HashMap<>();
        visit = new boolean[amount.length];

        for(int i=0;i<nodes.length; i++){ nodes[i]=new ArrayList<>(); }

        for(int i=0;i<edges.length;i++){
            nodes[edges[i][0]].add(edges[i][1]);
            nodes[edges[i][1]].add(edges[i][0]);
        }

        bobFind(bob,0);

        visit = new boolean[amount.length];
        maxCost = Integer.MIN_VALUE;
        dfs(0,0,amount[0],amount);

        return maxCost;
    }

    private void dfs(int now, int depth, int cost, int[] amount){
        visit[now]=true;
        if(nodes[now].size()==1 && now!=0){
            maxCost = Math.max(cost,maxCost);
            return;
        }
        for(int next: nodes[now]){
            if(!visit[next]){
                int nextCost = amount[next];
                if(bobPath.containsKey(next)){
                    if(depth+1 > bobPath.get(next)){ nextCost = 0; }
                    else if(depth+1 == bobPath.get(next)){ nextCost = amount[next]/2; }
                }
                dfs(next,depth+1,cost+nextCost,amount);
            }
        }
    }

    private boolean bobFind(int now, int depth){
        bobPath.put(now, depth);
        visit[now]=true;
        if(now == 0){
            bobMaxDepth = depth;
            return true;
        }

        for(int next : nodes[now]){
            if(!visit[next] && bobFind(next,depth+1)){
                return true;
            }
        }
        bobPath.remove(now);
        return false;
    }
}
