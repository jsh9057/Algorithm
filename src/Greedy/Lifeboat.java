package Greedy;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String args[]){
        int[] people={70, 80, 50};
        int limit= 100;
        int answer = 0;

        Arrays.sort(people);
        int minimum = 0;
        int maximum = people.length - 1;

        while(minimum <= maximum){
            if(minimum == maximum){ answer++;break;}
            else if(people[minimum]+people[maximum]<=limit){ minimum++; }
            maximum--;
            answer++;
        }
        System.out.println(answer);
    }
}
