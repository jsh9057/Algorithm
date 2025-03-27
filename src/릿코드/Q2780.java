package 릿코드;
import java.util.*;

public class Q2780 {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> right = new HashMap<>();
        HashMap<Integer,Integer> left = new HashMap<>();
        for(Integer n : nums){
            right.put(n,right.getOrDefault(n,0)+1);
        }
        for(int i=0;i<nums.size(); i++){
            int n = nums.get(i);
            int cnt = left.getOrDefault(n,0)+1;
            left.put(n,cnt);
            right.put(n,right.get(n)-1);
            if(
                    cnt > (i+1)/2 &&
                            right.get(n) > (nums.size()-1-i)/2
            ){return i;}
        }
        return -1;
    }
}
