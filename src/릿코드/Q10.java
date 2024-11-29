package 릿코드;

public class Q10 {
    char[] S,P;
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        S = s.toCharArray();
        P = p.toCharArray();
        memo = new Boolean[22][22];
        return dfs(0,0);
    }

    boolean dfs(int i, int k){
        if(memo[i][k]!= null ){ return memo[i][k]; }
        if(k==P.length){ return i==S.length; }

        if(k+1<P.length && P[k+1]=='*'){
            memo[i][k]=( i<S.length && (S[i]==P[k] || P[k]=='.') && dfs(i+1,k)) || (dfs(i,k+2));
            return memo[i][k];
        }
        if( (i<S.length && S[i]==P[k]) || P[k]=='.'){
            memo[i][k]= dfs(i+1,k+1);
            return memo[i][k];
        }
        memo[i][k]=false;
        return false;
    }
}
