package 릿코드;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    static List<String> ret;
    static char[][] charArr = {{},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<String>();
        if(digits.length()==0){ return ret; }
        rec(digits, 0, "");
        return ret;
    }

    void rec(String digits, int depth, String now){
        if(depth == digits.length()){ ret.add(now); return; }
        char c = digits.charAt(depth);
        int idx = c-'0'-1;
        for(int i=0; i<charArr[idx].length; i++){
            rec(digits, depth+1, now+charArr[idx][i]);
        }
    }
}
