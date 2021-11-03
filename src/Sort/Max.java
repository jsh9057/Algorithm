package Sort;

import java.util.*;

public class Max {
    static int Maxsize= 3;

    public static String[] traceItoS(int[] arr){
        int length = arr.length;
        String[] value = new String [length];
        for(int i=0; i<length; i++)
            value[i]=String.valueOf(arr[i]).repeat(Maxsize);
        for(String s:value)
            System.out.println(s);
        return value;
    }

    public static String traceSub (String[] arr){
        int length = arr.length;
        String value ="";
        for(int i=0; i<length; i++)
            value = value + arr[i].substring(0,arr[i].length()/Maxsize);
        return value;
    }

    public static void main(String[] args){
//        int [] numbers = {3, 30, 34, 5, 9};
        int [] numbers = {2,20,200};
//        int [] numbers = {6,10,2};
//        int [] numbers = {0,0,0,0};
        String answer;
        String[] arr=traceItoS(numbers);
        Arrays.sort(arr,Collections.reverseOrder());
        answer = traceSub(arr);
        if (answer.charAt(0)=='0')
            answer="0";
        System.out.println(answer);
    }
}
