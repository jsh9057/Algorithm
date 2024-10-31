package 릿코드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1671 {
    public static void main(String[] args) throws Exception{
        System.out.println(minimumMountainRemovals(new int[]{2,3,4,1,2,7,4,5,6}));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split =br.readLine().split(" ");
    }

    static class Item implements Comparator<Item> {
        int w;
        int v;

        @Override
        public int compare(Item o1, Item o2) {
            return 0;
        }
    }

    static public int minimumMountainRemovals(int[] nums) {
        int[] increaseDp = new int[nums.length];
        // 2 3 4 1 2 7 4 5 6
        for (int i = 0; i < nums.length; i++) {
            increaseDp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    increaseDp[i] = Math.max(increaseDp[i], increaseDp[j] + 1);
                }
            }
        }

        int[] decreaseDp = new int[nums.length];
        for (int i = nums.length-1; i>=0 ; i--) {
            decreaseDp[i]=1;
            for (int j = nums.length-1; j > i; j--) {
                if(nums[i]>nums[j]){
                    decreaseDp[i] = Math.max(decreaseDp[i], decreaseDp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(increaseDp));
        System.out.println(Arrays.toString(decreaseDp));
        int max = 0;

        /*
        오답노트
        산 수열을 구하는 문제 [ 1,2,3,2,1 ] <- 산 수열
        주어진 수열을 산 수열로 만들때 방해되는 요소를 없애고. 없앤 요소가 가장 적은 갯수 반환

        1. LIS 를 사용해서 왼쪽부터 증가수열을 구한다.
        2. LIS 를 사용해서 오른쪽부터 증가수열을 구한다.
        3. 구한 dp 배열을 순회하며 왼dp[i] + 오dp[i] 값이 최대인걸 구한다.
             여기서 실수한점!
             5432 131 경우
             왼DP {1,1,1,1,1,2,1}
             오DP {5,4,3,2,1,2,1}
             봉우리가 될 수 있는 조건은 요소가 2이상이어야함(증가수열의 최소치)
             dp 요소의 1은 증가 수열이 아니고 그냥 수열임.
         */
        for (int i = 1; i < nums.length-1; i++) {
            if(increaseDp[i]==1){continue;}
            if(decreaseDp[i]==1){continue;}
            if(max < decreaseDp[i]+increaseDp[i]){
                System.out.println("["+i+"]");
                max = Math.max(decreaseDp[i]+increaseDp[i],max);
            }
        }
        return nums.length - max + 1;
    }
}
