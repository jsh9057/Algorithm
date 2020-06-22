package Heap;


import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriority {
    public static void main(String args[]) {
//        String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1","D -1", "D 1", "D -1",
//                "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"};
//        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
//        String[] operations ={"I 1", "I 5", "I 3", "D 1"};
//        String[] operations = {"I 16","D 1"};
//        String[] operations = {"I 7","I 5","I -5","D -1"};
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = {0, 0};
        String[] splitArr;
        int commandCount = 0;
        int numberCount = 0;
        PriorityQueue<Integer> increaseQueue = new PriorityQueue<>();
        PriorityQueue<Integer> decreaseQueue = new PriorityQueue<>(operations.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 <= o2 ? 1 : -1;
            }
        });

        for (int i = 0; i < operations.length; i++) {
            splitArr = operations[i].split(" ");
            if (splitArr[0].equals("I")) {
                increaseQueue.offer(Integer.parseInt(splitArr[1]));
                decreaseQueue.offer(Integer.parseInt(splitArr[1]));
                numberCount++;
            } else {
                if (splitArr[1].equals("1")) {
                    decreaseQueue.poll();
                } else {
                    increaseQueue.poll();
                }
                    commandCount++;
            }
            if(commandCount>=numberCount) {
                increaseQueue.clear();
                decreaseQueue.clear();
                commandCount=0;
                numberCount=0;
            }
        }
        if(commandCount != numberCount){
            answer[0]=decreaseQueue.poll();
            answer[1]=increaseQueue.poll();
        }
        System.out.println("촤대값: "+answer[0]+ " 최소값: "+answer[1]);
    }
}
