package 릿코드;
import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){ continue; }
            int j = i+1;
            int end = nums.length-1;
            while(j<end){
                if(nums[i]+nums[j]+nums[end]==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[end]));
                    j++;
                    end--;
                }
                else if(nums[i]+nums[j]+nums[end]<0){
                    j++;
                }
                else{
                    end--;
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>(set);
        return ret;
    }
}
