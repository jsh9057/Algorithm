package study;

import java.util.PriorityQueue;

public class NightShift {
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> b-a);
        for (int w: works){ q.add(w); }
        for (int i = 0; i < n; i++) {
            int now = q.poll();
            if(now - 1 < 0){ q.add(0); }
            else{ q.add(now-1); }
        }

        while (!q.isEmpty()){
            int now = q.poll();
            answer+=((long) now *now);
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        solution(4,new int[]{4, 3, 3});
        solution(1,new int[]{2, 1, 2});
        solution(3,new int[]{1,1});
    }
}
