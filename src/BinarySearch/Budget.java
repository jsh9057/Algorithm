package BinarySearch;

import java.util.Arrays;

public class Budget {
    public static void main(String args[]){
        int[] budgets ={5,5,5,5,15,30};
        int M =62;

        int answer=0;
        int bLength=budgets.length;
        Arrays.sort(budgets);
        int left=M/bLength; //135
        int right=budgets[bLength-1]; //150
        long maxSum=0;
        if(left>=right){ System.out.println(right);}
        while (left<=right){
        int mid=(left+right)/2; //
        int sum=0;
            for(int n: budgets){
                if(n<=mid) {sum+=n;}
                else {sum+=mid;}
            }
            System.out.println("sum:"+sum);
            System.out.println("left:"+left+" mid:"+mid+" right:"+right);
            if(sum>M){ right=mid-1;}
            else{
                if(maxSum<sum){maxSum=sum; answer=mid;}
                left=mid+1;
            }
        }
        System.out.println(answer);
    }

}
