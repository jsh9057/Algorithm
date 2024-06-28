package KAKAO2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q3 {
    static List<String> combList;
    static List<Integer> bitComb;
    static int maxCol;
    public static int solution(String[][] relation) {
        int answer = 0;
        combList = new ArrayList<>();
        maxCol = relation[0].length;
        bitComb = new ArrayList<>();

        for (int i = 1; i <= maxCol; i++) { comb(0,0,i,""); }

        for (int i = 0; i < combList.size(); i++) {
            String strComb = combList.get(i);
            int bit = 0;
            for (int j = 0; j < strComb.length(); j++) { bit+=1<<strComb.charAt(j)-'0'; }
            bitComb.add(bit);
        }

        ArrayList<Integer> uniq = new ArrayList<>();
        for (int i = 0; i < combList.size(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < relation.length; j++) {
                StringBuilder str = new StringBuilder();
                for (int k = 0; k < combList.get(i).length(); k++) {
                    str.append(relation[j][combList.get(i).charAt(k) - '0']);
                }
                set.add(str.toString());
            }
            if(relation.length == set.size()){ uniq.add(bitComb.get(i)); }
        }

        Set<Integer> candidate = new HashSet<>(uniq);
        for (int i = 0; i < uniq.size(); i++) {
            for (int j = i+1; j < uniq.size(); j++) {
                if(uniq.get(i) == (uniq.get(i) & uniq.get(j))){ candidate.remove(uniq.get(j)); }
            }
        }
        return candidate.size();
    }

    static void comb(int idx, int depth, int maxDepth, String c){
        if (depth == maxDepth){ combList.add(c); return; }

        for (int i=idx; i<maxCol; i++){
            comb(i+1,depth+1,maxDepth,c+i);
        }
    }

    public static void main(String[] args) {
        solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
    }
}
