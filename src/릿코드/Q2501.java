package 릿코드;

import java.util.Arrays;
import java.util.HashSet;

public class Q2501 {
    public static void main(String[] args) {
//        System.out.println(longestSquareStreak(new int[]{4,16,256,65536}));
        System.out.println(longestSquareStreak2(new int[]{2,3,5,7,49,2401}));
    }
    static public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int end = nums[len-1];
        boolean[] isContain = new boolean[end+1];
        boolean[] isChecked = new boolean[end+1];
        for (int i = 0; i < len; i++) { isContain[nums[i]] = true; }

        int result = 0;
        for (int i = 0 ; i < len; i++) {
            int start = nums[i];
            int now = 1;
            if(start>316){ break; }
            for (int j = start*start; j <= end;) {
                if(isChecked[j] || !isContain[j]) {break;}
                if(isContain[j]){
                    isChecked[j]=true;
                    now++;
                    System.out.println(j);
                }
                if(j>316){break;}
                j*=j;
            }
            result = Math.max(result, now);
        }
        if(result <= 1){ return -1; }
        return result;
    }

    static public int longestSquareStreak2(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        HashSet<Integer> isVisit = new HashSet<>();

        int ret = 0;
        boolean go = false;
        for (int i = 0; i < len; i++) {
            int now = nums[i];
            int cnt = 1;
            if(isVisit.contains(now)){continue;}
            isVisit.add(now);
            while (true){
                long next = (long) now*now;
                if(next > 100000){ break; }

                if(!isVisit.contains(next) && binarySearch(nums, next)){
                    isVisit.add((int)next);
                    cnt++;
                }
                else{ break; }
                now *= now;
            }
            ret = Math.max(ret,cnt);
            if(!go && ret == 2){
                System.out.println(nums[i]);
                System.out.println(nums[i]*nums[i]);
                go = true;
            }
        }

        if(ret == 1){ return -1;}
        return ret;
    }

    public static boolean binarySearch(int[] arr, long target) {
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]<target){
                start = mid+1;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else return true;
        }
        return false;
    }
}
