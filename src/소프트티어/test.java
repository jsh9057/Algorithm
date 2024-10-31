package 소프트티어;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        clear(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void clear(int[] arr){
        for (int i = 0; i < arr.length; i++) { arr[i]=0; }
    }
}
