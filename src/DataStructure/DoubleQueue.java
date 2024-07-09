package DataStructure;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DoubleQueue {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>((o1, o2) -> o1-o2);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2-o1);

        int size = 0;
        for (String o : operations){
            String[] split = o.split(" ");
            if(split[0].equals("I")){
                maxQ.add(Integer.parseInt(split[1]));
                minQ.add(Integer.parseInt(split[1]));
                size++;
            }
            else{
                if( size == 0 ){ continue; }
                if(split[1].equals("1")) { maxQ.poll();}
                else{ minQ.poll();}
                size--;

                if(size == 0){
                    minQ.clear();;
                    maxQ.clear();
                }
            }
        }

        if(size==0){ return new int[]{0,0}; }

        else{ return new int[]{maxQ.poll(), minQ.poll()}; }
    }
    public static void main(String[] args) {
        solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(Arrays.toString(solution(new String[]{"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"})));
    }
}