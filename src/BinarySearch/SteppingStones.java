package BinarySearch;

import java.util.Arrays;

public class SteppingStones {

    public static void main(String args[]){
        int distance=25;
        int[] rocks={2,14,11,21,17};
        int n=2;
        SteppingStones steppingStones=new SteppingStones();
        System.out.println(steppingStones.BinarySearch(distance,rocks,n));

    }

    public int BinarySearch(int distance, int[] rocks, int n){
        int answer=0;
        Arrays.sort(rocks);
        int left=0;
        int right=distance;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            int prv=0;
            int removeCnt=0;
            for(int i=0; i<rocks.length; i++){
                if(rocks[i]-prv < mid){ removeCnt++; if(removeCnt>n){break;}}
                else{ prv=rocks[i]; }
            }
            if(removeCnt>n){right=mid-1;}
            else{answer=answer>mid? answer:mid; left=mid+1;}
        }
        return answer;
    }
}


