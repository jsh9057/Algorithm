package 릿코드;
import java.util.*;

public class Q22 {
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        dfs(0,0,n,"");
        return ret;
    }
    void dfs(int op, int cl, int n, String s){
        if(op == cl && op == n){ ret.add(s); }
        if(op < n){ dfs(op+1, cl, n, s+"(");}
        if(op > cl){ dfs(op, cl+1, n, s+")"); }
    }
}
