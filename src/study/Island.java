package study;

import java.util.ArrayList;

public class Island {
    static ArrayList<int[]> edge;
    static int[] parent;
    static int N;
    public static int solution(int n, int[][] costs) {
        N = n;
        edge = new ArrayList<>();
        for (int[] c: costs){ edge.add(new int[]{c[0],c[1],c[2]}); }
        edge.sort((a,b) -> a[2]-b[2]);
        for (int[] e: edge){
            System.out.println(e[2]);
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) { parent[i]=i; }
        return kruskal();
    }

    static int find(int idx){
        if(parent[idx]==idx) {return idx;}
        else{ return find(parent[idx]); }
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x>y){ parent[x]=y; }
        else{ parent[y]=x; }
    }

    static int kruskal(){
        int cost = 0;
        int cnt = 0;
        for (int[] ints : edge) {
            int from = ints[0];
            int to = ints[1];
            int c = ints[2];
            if (find(from) != find(to)) {
                union(from, to);
                cost += c;
                cnt++;
            }
            if (cnt == N - 1) { break; }
        }
        System.out.println(cost);
        return cost;
    }



    public static void main(String[] args) {
        solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});

    }
}
