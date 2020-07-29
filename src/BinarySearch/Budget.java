package BinarySearch;

import java.util.Arrays;

public class Budget {
    public static void main(String args[]){
        int[] budgets ={5,5,5,5,15,30};
        int M =62;

        int answer=0;
        answer=binarySearch(budgets,M);
        System.out.println(answer);
    }
    public static int binarySearch(int[] budgets , int M){
        int answer=0;
        int bLength=budgets.length;
        Arrays.sort(budgets);
        int left=M/bLength; //135
        int right=budgets[bLength-1]; //150
        long maxSum=0;
        if(left>=right){ return right;}
        while (left<=right){
            int mid=(left+right)/2; //
            long sum=0;
            for(int n: budgets){
                if(n<=mid) {sum+=n;}
                else {sum+=mid;}
            }
            if(sum>M){ right=mid-1;}
            else{
                if(maxSum<sum){maxSum=sum; answer=mid;}
                left=mid+1;
            }
        }
        return answer;
    }

}
