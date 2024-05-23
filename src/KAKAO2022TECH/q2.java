package KAKAO2022TECH;

import java.util.LinkedList;
import java.util.Queue;

public class q2 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (long q : queue1){ q1.add(q); sum1+=q; }
        for (long q : queue2){ q2.add(q); sum2+=q; }

        int i= q1.size()*4;
        while(i>0){
            if(sum1 > sum2){
                long n = q1.poll();
                sum2+= n;
                sum1-= n;
                q2.add(n);
            }
            else if(sum1 < sum2){
                long n = q2.poll();
                sum1+= n;
                sum2-= n;
                q1.add(n);
            }
            else {
                System.out.println(answer);
                return answer;
            }
            answer++;
            i--;
        }
        System.out.println(-1);
        return -1;
    }

    public static void main(String[] args) {
        solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        // 2
        solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        // 7
        solution(new int[]{1, 1}, new int[]{1, 5});
        // -1
        solution(new int[]{9, 7, 2}, new int[]{9, 2, 11});
        // 3
    }
}
