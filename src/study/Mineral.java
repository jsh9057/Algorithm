package study;

import java.util.ArrayList;
import java.util.Arrays;

public class Mineral {
    static final int[][] kind = {{1,1,1},{5,1,1},{25,5,1}};
    static final int[] mineralsToScore = {25,5,1};
    public static int solution(int[] picks, String[] minerals) {
        ArrayList<Score> score = new ArrayList<>();
        int s = 0;
        for (int i = 0; i < minerals.length; i++) {
            s += mineralsToScore[StringToInt(minerals[i])];
            if((i+1)%5==0){score.add(new Score(s,score.size())); s=0;}
        }
        if(s!=0){ score.add(new Score(s,score.size())); }

        int maxLen = picks[0] + picks[1] + picks[2];
        if(maxLen < score.size()){ score = new ArrayList<>(score.subList(0,maxLen)); }
        score.sort((o1,o2) -> o2.score - o1.score);

        int[] pickList = new int[score.size()];
        for(Score sc: score){
            if(picks[0]>0){ pickList[sc.n]=0; picks[0]--;}
            else if(picks[1]>0){ pickList[sc.n]=1; picks[1]--; }
            else if(picks[2]>0){ pickList[sc.n]=2; picks[2]--; }
        }

        int idx = 0;
        int use = 0;
        int total = 0;
        for (int i = 0; i < minerals.length; i++) {
            if(use==5){ idx++; use=0; }
            if(idx==pickList.length){break;}
            int mineral = StringToInt(minerals[i]);
            int pick = pickList[idx];
            total+= kind[pick][mineral];
            use++;
        }
        System.out.println(total);
        return total;
    }

    static class Score {
        int score;
        int n;

        public Score(int score, int n) {
            this.score = score;
            this.n = n;
        }
    }
    static int StringToInt(String str){
        if(str.equals("diamond")){return 0;}
        else if(str.equals("iron")){ return 1;}
        else{return 2;}
    }

    public static void main(String[] args) {
        solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"});
    }
}
