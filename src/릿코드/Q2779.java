package 릿코드;
import java.util.*;

public class Q2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums[nums.length-1]+k+2;
        int[] count = new int[len];

        for(int n : nums){
            count[Math.max(n-k,0)]+=1;
            count[n+k+1]-=1;
        }
        int ret = 0;
        for(int i=1; i<len; i++){
            count[i] += count[i-1];
            ret = Math.max(count[i],ret);
        }
        return ret;
    }
}
