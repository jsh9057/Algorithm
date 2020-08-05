package BinarySearch;


import java.util.Arrays;

public class Immigration {
    public static void main(String args[]){
        int n=6;
        int[] times={7,10};
        long answer;
        System.out.println(binarySearch(n,times));
    }

public static long binarySearch(int n, int[] times){
    Arrays.sort(times);
    int timeLength=times.length;
    long left = 1;
    long right = (long)times[timeLength-1]*n;
    long mid=right;
    long answer=right;
    while(left<=right){
        mid =(left+right)/2;
        long count=0;
//            System.out.println("left: "+left+" mid: "+mid+" right: "+right);
        for(int i=0; i<timeLength; i++){
            count+=mid/times[i];
        }
        if(count<n){left=mid+1;}
        else {
            if(mid<answer) {answer = mid;}
        right=mid-1;}
    }
    return answer;
}
}
