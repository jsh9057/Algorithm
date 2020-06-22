package Stack_Queeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stock {
    public static void main(String args[]) {
        int[] prices={5,4,7,2,1,1};
        int[] answer = new int[prices.length];
        Stack<Integer> priceStack = new Stack<>();
        Stack<Integer[]> Stack = new Stack<>();
        Stack<Integer> answerStack= new Stack<>();
        for(int i=0; i<prices.length-1; i++)
            priceStack.push(prices[i]);

        while(!priceStack.isEmpty()) {
            int day = 0;
            int nowPrice = priceStack.pop();
            System.out.println("nowPrice: " + nowPrice);
            if (!Stack.isEmpty() && Stack.peek()[0] >= nowPrice) {
                System.out.println("Stack.peek() : " + Stack.peek()[0]);
                while (Stack.peek()[0]>=nowPrice) {
                    System.out.println("asd");
                    day = day + Stack.pop()[1];
                }
            }
            System.out.println("Stack push: "+nowPrice +" "+(day+1));
            Stack.push(new Integer[]{nowPrice, day + 1});
            answerStack.push(day + 1);
        }
        int index=0;
        while (!answerStack.isEmpty()){
            answer[index]=answerStack.pop();
            index++;
        }
        for(int i=0; i<answer.length; i++)
            System.out.println(answer[i]);
    }

}
