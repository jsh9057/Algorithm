package KAKAO2019;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q2 {
    public static int[] solution(int N, int[] stages) {
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        int[] stage = new int[N+2];
        int userCnt = stages.length;

        for (int s: stages){ stage[s]++; }
        for (int i = 1; i <= N; i++) {
            double failRate = userCnt==0 ? 0 : (double) stage[i] /userCnt;
            pq.add(new Stage(i,failRate));

            System.out.println(stage[i]+"/"+userCnt);
            userCnt-=stage[i];
        }
        int[] answer = new int[N];
        int idx=0;
        while (!pq.isEmpty()){ answer[idx++]=pq.poll().stageNum; }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static class Stage implements Comparable<Stage>{
        int stageNum;
        double failRate;

        public Stage(int stageNum, double failRate) {
            this.stageNum = stageNum;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Stage o) {
            if(this.failRate ==  o.failRate){ return Integer.compare(this.stageNum, o.stageNum); }
            return Double.compare(o.failRate,this.failRate);
        }
    }

    public static void main(String[] args) {
        solution(5,new int[]{1,1,1,2,3,4});
//        solution(4,new int[]{4,4,4,4,4});
    }
}