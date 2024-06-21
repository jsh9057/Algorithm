package KAKAO2020BLIND;

import java.util.*;

public class q6 {
    static int[] weakArr;
    static int[] distArr;

    static int min;
    static int N;
    static int weakCount;
    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        N = n;
        weakCount = weak.length*2;
        weakArr = new int[weak.length*2];
        for (int i = 0; i < weak.length; i++) {
            weakArr[i]=weak[i];
            weakArr[i+weak.length]=weak[i]+N;
        }
        Arrays.sort(dist);
        distArr = new int[dist.length];

        for (int i = 0; i < dist.length; i++) { distArr[dist.length-i-1]=dist[i]; }

        min = Integer.MAX_VALUE;

        for (int i = 0; i < weakArr.length; i++) {
            dfs(i,0, new HashSet<>());
        }
        System.out.println(min);
        if(min == Integer.MAX_VALUE) return -1;
        return answer;
    }

    static void dfs(int w, int depth, HashSet<Integer> repaired){
        if(min<=depth){return; }
        if(repaired.size()==weakCount){ min = depth; return;}
        if(distArr.length <= depth){return;}
        if(repaired.contains(w)){ return; }

        for (int i = w; i < weakArr.length ; i++) {
            if(weakArr[w]+distArr[depth] >= weakArr[i]){
                if(i>=weakArr.length/2){ repaired.add(i-weakArr.length/2); }
                else{ repaired.add(i+weakArr.length/2); }
                repaired.add(i);
            }
            else {break;}
        }
            for (int j = w; j < weakArr.length; j++) {
                dfs(j,depth+1, new HashSet<>(repaired));
            }

    }
    public static void main(String[] args) {
        solution(12,new int[]{1, 5, 6, 10},new int[]{1, 2, 3, 4});
        solution(12,new int[]{1, 3, 4, 9, 10},new int[]{3, 5, 7});
    }
}
