package 릿코드;
import java.util.*;
public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // -5,-5,-4,0,0,3,3,4,5
        int min = nums[0]+nums[1]+nums[2];
        for(int start=0; start<nums.length; start++){
            int mid = start+1;
            int end = nums.length-1;
            while(mid < end){
                int sum = nums[start]+nums[mid]+nums[end];
                if(sum==target){ return sum; }
                if(Math.abs(target-sum)<Math.abs(target-min)){ min = sum; }
                if(sum > target){ end--; }
                else{ mid ++; }
            }
        }
        return min;
    }
}
