package 소프트티어;

import java.util.Arrays;
import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:arr){list.add(i);}

        System.out.println(up(list,11));
    }
    static int up(ArrayList<Integer> list, int target){
        int start = 0;
        int end = list.size();
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            if(list.get(mid) <= target){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return end;
    }
}
