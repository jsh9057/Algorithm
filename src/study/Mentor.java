package study;

import java.util.*;

public class Mentor {
    public static int solution(int k, int n, int[][] reqs) {
        Queue<Integer>[][] mentor = new Queue[k+1][20];
        int[][] wait = new int[k+1][20];

        for (int max = 1; max <= n; max++) {
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < 20; j++) { mentor[i][j]=new LinkedList<>(); }   // init
            }

            for (int i = 0; i < reqs.length; i++) {
                int start = reqs[i][0];
                int ing = reqs[i][1];
                int kind = reqs[i][2];

                boolean isAdd = false;
                int minMentor=-1;
                int minTime=Integer.MAX_VALUE/2;
                for (int j = 0; j < max; j++) {
                    if(mentor[kind][j].isEmpty()){
                        mentor[kind][j].add(start+ing);
                        isAdd=true;
                        break;
                    }
                    else{
                        if(minTime>mentor[kind][j].peek()){
                            minTime = mentor[kind][j].peek();
                            minMentor = j;
                        }
                    }
                }
                if(!isAdd){
                    int end = mentor[kind][minMentor].poll();
                    if(end>start){
                        mentor[kind][minMentor].add(end+ing);
                        wait[kind][max-1]+=(end-start);
                    }
                    else{ mentor[kind][minMentor].add(start+ing); }
                }
            }
        }
        
        int total = 0;
        for (int i = 1; i <= k; i++) { total+=wait[i][0]; }

        int diff = n-k;
        int[] idx = new int[k+1];
        while (diff>0){
            int max = 0;
            int maxIdx = 0;
                for (int kind = 1; kind <= k; kind++) {
                int tmp = wait[kind][idx[kind]] - wait[kind][idx[kind]+1];
                if(tmp > max){
                    max = tmp;
                    maxIdx = kind;
                }
            }
            idx[maxIdx]++;
            total-=max;
            diff--;
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        solution(3,5,new int[][]{{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}});
        solution(2,3,new int[][]{{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}});

    }
}
