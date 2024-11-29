package 릿코드;
import java.util.*;

public class Q3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Node>[] graph = new ArrayList[n];
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
            dist[i]=i;
        }
        for(int i=0;i<n-1;i++){ graph[i].add(new Node(i+1,1)); }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2) -> n1.cost-n2.cost);
        boolean[] isVisit = new boolean[n];

        int[] ret = new int[queries.length];
        int cnt=0;
        for(int[] q: queries){
            Arrays.fill(isVisit,false);
            graph[q[0]].add(new Node(q[1],1));  // update edge
            pq.add(new Node(q[0],dist[q[0]]));  // from updated node

            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(isVisit[now.index]){ continue; }
                isVisit[now.index]=true;

                for(Node next: graph[now.index]){
                    // now -(cost)-> next
                    // vs
                    // dist[next] (before dist info)
                    if(dist[next.index]> dist[now.index]+next.cost){
                        dist[next.index] = dist[now.index]+next.cost;
                        pq.add(new Node(next.index, dist[next.index]));

                    }
                }
            }
            ret[cnt++]=dist[n-1];
        }
        return ret;
    }

    static class Node{
        int index;
        int cost;

        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }
}
