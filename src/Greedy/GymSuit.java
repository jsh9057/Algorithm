package Greedy;

import java.util.Arrays;

public class GymSuit {
    public static void main(String[] args){
        int n=7;
        int[] lost={2,3,4};
        int[] reserve={1,2,3,6};
        int answer = 0;

        Boolean[] isHave = new Boolean[n];
        Arrays.fill(isHave,true);

        for(int i=0; i<lost.length; i++)
            isHave[lost[i]-1]=false;

        for(int i=0; i<reserve.length; i++)
            if(!isHave[reserve[i]-1]) {isHave[reserve[i]-1]=true; reserve[i]=0;}

        for(int i=0;i<reserve.length; i++){
            int index= reserve[i]-1;
            if(reserve[i]!=0) {
               if (index > 0 && !isHave[index - 1]) { isHave[index - 1] = true; }
               else if (index < n - 1 && !isHave[index + 1]) { isHave[index + 1] = true; }
            }
        }

        for(int i=0; i<isHave.length; i++ )
            if (isHave[i]){ answer ++;}

        System.out.println(answer);
    }
}
