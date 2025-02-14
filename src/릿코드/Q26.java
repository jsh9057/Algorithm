package 릿코드;
import java.util.*;

public class Q26 {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            nums[set.size()-1]=nums[i];
        }
        return set.size();
    }
}
