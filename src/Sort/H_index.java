package Sort;
import java.util.*;
public class H_index {
    public static void main(String[] args){
//        Integer[] citations={0, 1, 1, 1, 1, 3, 3, 4};
//        Integer[] citations={0, 1, 3, 5, 5, 5, 5, 5, 5, 6};
//        Integer[] citations={5, 5, 5, 5,5};
//        Integer[] citations={0,0,1};
//        Integer[] citations={2,7,5};
        Integer[] citations = {5,5,5,5};
//        int[] citations = {3,0,6,1,5};

        int answer = 0;
        int length = citations.length;
        Integer[] arr = new Integer[length];
        for(int i=0; i<length; i++)
            arr[i]=citations[i];
        Arrays.sort(arr,Collections.reverseOrder());
        while(arr[answer]>answer&&answer<length) {
            answer++;
            if(length==answer)
                break;
        }
        System.out.println(answer);
    }
}