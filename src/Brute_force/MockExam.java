package Brute_force;

import java.util.*;

public class MockExam {
    public static void main(String[] args){
//        int[] answers = {1,2,3,4,5};
//        int[] answers = {1,3,2,4,2};
        int[] answers = {2,1,2,3,2,4,2,5};
        int[] p1A = {1, 2, 3, 4, 5};
        int[] p2A ={2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3A = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] hit = new int[3];

        for(int i=0; i<answers.length; i++){
            if(p1A[i%5]==answers[i])
                hit[0]++;
            if(p2A[i%8]==answers[i])
                hit[1]++;
            if(p3A[i%10]==answers[i])
                hit[2]++;
        }
        for(int i=0; i<3; i++)
            System.out.println(i+1+"번쨰 사람: "+hit[i]);
        int max =0;
        for(int i=0; i<3; i++){
            if (hit[i]>=max)
                max=hit[i];
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == hit[i])
                arr.add(i+1);
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++)
            answer[i]=arr.get(i);

        for(int i=0; i<answer.length; i++)
            System.out.println(answer[i]);
    }
}
