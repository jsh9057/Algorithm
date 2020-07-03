package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {
    static int root[];

    public static void main(String args[]){
        int[] n = {4,6,4};
        int[][][] costs={{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}},
                {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}},
                {{0,1,1},{0,2,2},{2,3,1}}
        };

        int i=2;
        System.out.println(solution(n[i],costs[i]));
    }

    public static int solution (int n, int costs[][]){
        int size = costs.length;
        root = new int[n];
        int bridge=0;
        int answer=0;

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i =0; i<n; i++)
            root[i]=i;

        for(int i=0; i<size; i++) {
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0],costs[i][1]);
                answer += costs[i][2];
                bridge++;
            }
            if(bridge == n-1) {break;}
        }
        return answer;
    }

    public static int find(int x){
        if(root[x] == x) { return x; }
        else { return find(root[x]); }
    }
    public static void union(int x, int y){
        x=find(x);
        y=find(y);
        root[y]=x;
    }
}
