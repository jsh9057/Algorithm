package 릿코드;
import java.util.*;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<len-3; i++){
            if(i>0 && nums[i]==nums[i-1]){ continue; }
            for(int j=i+1; j<len-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]){ continue; }
                int left = j+1;
                int right = len-1;

                while(left < right){
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum == target){
                        ret.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left]==nums[left-1]){ left++; }
                        while(left < right && nums[right]==nums[right+1]){ right--; }
                    }
                    else if(sum < target){ left++; }
                    else{ right--; }
                }
            }
        }
        return ret;
    }
}
