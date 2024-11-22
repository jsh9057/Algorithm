package 릿코드;
import java.util.*;
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<m;i++){ list1.add(nums1[i]); }
        for(int i=0;i<n;i++){ list2.add(nums2[i]); }

        int j=0;
        for(int i=0;i<m+j;i++){
            if(j<n && list1.get(i)>list2.get(j)){
                list1.add(i,list2.get(j)); j++;
            }
        }
        if(j<n){ list1.addAll(list2.subList(j,n)); }
        int idx=0;
        for(Integer e :list1){
            nums1[idx++]=e;
        }
    }
}
