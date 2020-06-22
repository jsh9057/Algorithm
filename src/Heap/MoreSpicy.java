package Heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String args[]){
        int []scoville = {1, 2, 3} ;
        int k = 13;
        int answer =0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++) {
            priorityQueue.offer(scoville[i]);
        }

        while(priorityQueue.peek()<k){
            if(priorityQueue.size()==1){
                answer=-1;
                break;
            }
            else{
                int smaller=0;
                int small=0;
                smaller = priorityQueue.poll();
                small = priorityQueue.poll();
                priorityQueue.offer(smaller + (small*2));
                answer++;
            }
        }
        System.out.println(answer);
    }
}
