package 릿코드;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        update(arr);
        System.out.println(Arrays.toString(arr));
    }
    static public void update(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]+1;
        }
    }
}
