package 릿코드;

import java.util.Arrays;

public class Q1671 {
    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{2,3,4,1,2,7,4,5,6}));
        System.out.println(lis(new int[]{2,3,4,1,2,7,4,5,6}));
    }

    static public int lis(int [] nums){
        int[] increaseDp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            increaseDp[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    increaseDp[i] = Math.max(increaseDp[i],increaseDp[j]+1);
                    max = Math.max(max,increaseDp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(increaseDp));
        return max;
    }


    static public int minimumMountainRemovals(int[] nums) {
        int[] increaseDp = new int[nums.length];
        // 2 3 4 1 2 7 4 5 6
        for (int i = 0; i < nums.length; i++) {
            increaseDp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    increaseDp[i] = Math.max(increaseDp[i], increaseDp[j] + 1);
                }
            }
        }

        int[] decreaseDp = new int[nums.length];
        for (int i = nums.length-1; i>=0 ; i--) {
            decreaseDp[i]=1;
            for (int j = nums.length-1; j > i; j--) {
                if(nums[i]>nums[j]){
                    decreaseDp[i] = Math.max(decreaseDp[i], decreaseDp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(increaseDp));
        System.out.println(Arrays.toString(decreaseDp));
        int max = 0;
        for (int i = 1; i < nums.length-1; i++) {
            if(increaseDp[i]==1){continue;}
            if(decreaseDp[i]==1){continue;}
            if(max < decreaseDp[i]+increaseDp[i]){
                System.out.println("["+i+"]");
                max = Math.max(decreaseDp[i]+increaseDp[i],max);
            }
        }
        return nums.length - max + 1;
    }
}
