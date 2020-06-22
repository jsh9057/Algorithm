package Sort;

import java.util.PriorityQueue;

public class Knumber {
    public static void main(String args[]){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int [] answer =new int[commands.length];
        PriorityQueue<Integer> increaseQueue = new PriorityQueue<Integer>();
        int start;
        int end;
        int index;
        for(int i=0; i<commands.length; i++){
            start = commands[i][0];
            end = commands[i][1];
            index = commands[i][2];
            for(int j=start-1 ; j<=end-1; j++){
                increaseQueue.offer(array[j]);
            }
            while(index!=0){
                answer[i]=increaseQueue.poll();
                index--;
            }
            increaseQueue.clear();
        }
        for (int i=0; i<answer.length; i++)
            System.out.println(answer[i]);
    }
}
