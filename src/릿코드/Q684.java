package 릿코드;

public class Q684 {
    static int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        parent = new int[N+1];
        for(int i=1;i<N+1;i++){ parent[i]=i; }

        int[] res = new int[2];
        for(int i=0;i<N;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(find(a)!=find(b)){ union(a,b); }
            else{ res[0]=a; res[1]=b; }
        }
        return res;
    }

    int find(int n){
        if(parent[n]==n){ return n; }
        return parent[n] = find(parent[n]);
    }

    void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a<b){ parent[b]=a; }
        else { parent[a]=b; }
    }
}
