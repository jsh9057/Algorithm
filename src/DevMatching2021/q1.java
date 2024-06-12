package DevMatching2021;

import java.util.HashSet;

public class q1 {
    static final int[] RANK = {6,6,5,4,3,2,1};
    public static int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> winNum = new HashSet<>();
        for(int w: win_nums){ winNum.add(w); }

        int hit = 0;
        int zero = 0;
        for (int l : lottos){
            if(l == 0){ zero ++; continue;}
            if(winNum.contains(l)){ hit++; }
        }
        return new int[]{RANK[hit+zero],RANK[hit]};
    }

    public static void main(String[] args) {
        solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
    }
}
