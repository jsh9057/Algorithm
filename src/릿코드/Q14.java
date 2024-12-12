package 릿코드;
import java.util.*;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length-1];
        String ret = "";
        for(int i = 0; i < Math.min(start.length(), end.length()); i++){
            if(start.charAt(i) == end.charAt(i)){
                ret+=start.charAt(i);
            }
            else{ break; }
        }
        return ret;
    }
}
