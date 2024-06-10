package KAKAO2022BLINDREC;

import java.util.Arrays;

public class q4 {
    static int[] aInfo;
    static int maxGap;
    static int[] ret;

    public static int[] solution(int n, int[] info) {
        aInfo = info.clone();
        maxGap = 0;
        ret = null;

        comb(0,0,new int[n], n);

        if(maxGap == 0){ return new int[] {-1}; }
        return ret;

    }

    public static void comb(int idx, int cnt, int[] scores, int n){
        if(cnt==n){
            int[] bInfo = toInfo(scores);
            int gap = getCal(bInfo);

            if(gap>maxGap){
                maxGap = gap;
                ret = bInfo;
            }
            return;
        }
        for (int i = idx; i < 11; i++) {
            scores[cnt] = i;
            comb(i,cnt+1, scores, n);
        }
    }

    public static int[] toInfo(int[] score){
        int[] ret = new int[11];
        for(int s : score){
            ret[10-s]++;
        }
        return ret;
    }

    public static int getCal(int[] bInfo){
        int aScore = 0;
        int bScore = 0;
        for (int i = 0; i < 11; i++) {
            if(bInfo[i]==0 && aInfo[i]==0) { continue; }
            else if(bInfo[i]>aInfo[i]){ bScore+=(10-i); }
            else{ aScore+=(10-i); }
        }
        return bScore - aScore;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5,new int[]{2,1,1,1,0,0,0,0,0,0,0})));
        //[0,2,2,0,1,0,0,0,0,0,0]
        System.out.println(Arrays.toString(solution(1,new int[]{1,0,0,0,0,0,0,0,0,0,0})));
        //[-1]
        System.out.println(Arrays.toString(solution(9,new int[]{0,0,1,2,0,1,1,1,1,1,1})));
        //[1,1,2,0,1,2,2,0,0,0,0]
        System.out.println(Arrays.toString(solution(10,new int[]{0,0,0,0,0,0,0,0,3,4,3})));
        //[1,1,1,1,1,1,1,1,0,0,2]
    }
}
