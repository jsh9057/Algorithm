package KAKAO2023BLINDRE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q7 {
    public static int[] solution(int[][] edges, int[] target) {
        int N = edges.length+1;
        ArrayList<Integer>[] tree = new ArrayList[N];
        int[] pass = new int[N];
        int[] cnt = new int[N];
        boolean[] check = new boolean[N];
        ArrayList<Integer> leaf = new ArrayList<>();

        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            if(tree[from-1]== null){ tree[from-1]= new ArrayList<>();}
            if(tree[to-1]== null){ tree[to-1]= new ArrayList<>();}
            tree[from-1].add(to-1);
        }
        for (ArrayList<Integer> t: tree){ Collections.sort(t); }

        int leafCnt = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i].size() == 0 && target[i]>0){leafCnt++;}
        }

        while (leafCnt>0) {
            int now = 0;
            while (tree[now].size() != 0){
                now = tree[now].get(pass[now]++%tree[now].size());
            }
            cnt[now]++;
            leaf.add(now);

            if(target[now] < cnt[now]){return new int[] {-1};}
            if(!check[now]&& target[now]<= cnt[now]*3){
                check[now] = true;
                leafCnt --;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Integer now : leaf){
            cnt[now]--;
            for (int i = 1; i <=3 ; i++) {
                int card = i;
                if(cnt[now] <= target[now]-card && target[now]-card <= (cnt[now])*3){
                    target[now]-=card;
                    result.add(card);
                    break;
                }
            }
        }
        System.out.println(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        solution(new int[][] {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}}, new int[] {0, 0, 0, 3, 0, 0, 5, 1, 2, 3});
        // [1, 1, 2, 2, 2, 3, 3]
        solution(new int[][] {{1, 2}, {1, 3}}, new int[] {0, 7, 3});
        // [1, 1, 3, 2, 3]
        solution(new int[][] {{1, 3}, {1, 2}}, new int[] {0, 7, 1});
        // [-1]
    }
}
