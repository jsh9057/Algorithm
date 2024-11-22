package 릿코드;
import java.util.*;

public class Q2461 {
    HashMap<Integer, Integer> map;
    public long maximumSubarraySum(int[] nums, int k) {
        map = new HashMap<>();
        long ret = 0;
        long sum = 0;

        for(int i=0;i<k;i++){
            sum+=nums[i];
            add(nums[i]);
        }
        if(map.size() == k){ ret = sum; }

        for(int i=0;i<nums.length-k; i++){
            int j = i+k-1;
            sum = sum - nums[i] + nums[j+1];
            remove(nums[i]);
            add(nums[j+1]);
            if(map.size()==k){
                ret = Math.max(ret,sum);
            }
        }
        return ret;
    }

    public void remove(int n){
        map.put(n,map.get(n)-1);
        if(map.get(n)==0){ map.remove(n); }
    }
    public void add(int n){
        if(map.containsKey(n)){ map.put(n,map.get(n)+1); }
        else{ map.put(n,1); }
    }
}
