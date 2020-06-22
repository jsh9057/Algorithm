package Stack_Queeue;

import java.util.LinkedList;
import java.util.Queue;

public class Progress {
    public static void main(String args[]){
        int [] progresses ={93, 30, 55, 60, 40, 65};
        int [] speeds={1, 30, 5 , 10, 60, 7};
        int [] ans = new int[progresses.length];
        int index = 0;
        int open = 1;
        int standard =0;

        Queue<Integer> days = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            double day;
            day =(double) (100-progresses[i])/speeds[i];
            days.offer((int)Math.ceil(day));
            System.out.println("days : "+(int)Math.ceil(day));
        }
        standard = days.poll();
        while(!days.isEmpty()){
            if(standard >= days.peek()){
                days.poll();
                open++;
            }
            else if(standard < days.peek()){
                ans[index]=open;
                standard=days.poll();
                open = 1;
                index ++;
            }
            ans[index]=open;
        }
        int[] answer = new int [index+1];

        for(int i=0; i<=index; i++) {
            answer[i]= ans[i];
        }
        for(int i=0; i<answer.length; i++)
            System.out.println("answer : "+answer[i]);
    }
}
