package 릿코드;

public class Q2401 {
    public int longestNiceSubarray(int[] nums) {
        int usedBit = 0;
        int start =0;
        int maxLen = 0;
        for(int end=0; end<nums.length; end++){
            while((usedBit & nums[end]) != 0){
                usedBit = usedBit & (~nums[start]);
                // A & (~B)
                start++;
            }
            usedBit = usedBit|nums[end] ;
            maxLen = Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }
}
