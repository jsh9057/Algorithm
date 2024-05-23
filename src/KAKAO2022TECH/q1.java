package KAKAO2022TECH;

import java.util.HashMap;

public class q1 {
    static final char[][] mbti= {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char[] m : mbti){
            map.put(m[0],0);
            map.put(m[1],0);
        }

        for (int i = 0; i < survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            int score = choices[i];
            if(score==4){continue;}
            else if(score<4){map.put(c1,4-score + map.get(c1));}
            else {map.put(c2,score-4 + map.get(c2)); }
        }

        for(char[] m : mbti){
            if(map.get(m[0]) >= map.get(m[1])){ answer.append(m[0]); }
            else{answer.append(m[1]);}
        }
        System.out.println(map);
        System.out.println(answer);
        return answer.toString();
    }
    public static void main(String[] args) {
        solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        solution(new String[] {"TR", "RT", "TR"}, new int[]{7, 1, 3});
    }
}
