package 릿코드;

public class Q3191 {
    public int minOperations(int[] nums) {
        int cnt = 0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]==0 && i+2<nums.length){
                nums[i]= nums[i]^1;
                nums[i+1]= nums[i+1]^1;
                nums[i+2]= nums[i+2]^1;
                cnt++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){return -1;}
        }
        return cnt;
    }
}
