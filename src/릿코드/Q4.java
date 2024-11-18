package 릿코드;

public class Q4 {
    static int[] arr = new int[2000];
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 =0;
        int i2 =0;
        int idx =0;
        while(i1<nums1.length && i2<nums2.length){
            if(nums1[i1] <= nums2[i2]){
                arr[idx++] = nums1[i1++];
            }else{
                arr[idx++] = nums2[i2++];
            }
        }
        while(i1<nums1.length){ arr[idx++] = nums1[i1++]; }
        while(i2<nums2.length){ arr[idx++] = nums2[i2++]; }
        int totalLen = i1+i2;
        if(totalLen%2 == 0){
            return (double)(arr[totalLen/2] + arr[(totalLen/2)-1])/2;
        }
        else{
            return (double) arr[totalLen/2];
        }
    }
}
