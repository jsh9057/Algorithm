package DP;

public class Nnumber {
    static int n;
    static int target;
    static int answer=Integer.MAX_VALUE;

    public static void main(String args[]){
        int N=5;
        int number=12;
        n=N;
        target=number;
        dfs(0,0);
        if(answer>8){answer=-1;}
        System.out.println(answer);
    }

    static public void dfs(int count, int prev){
        if(count > 8){ answer = -1; return;}
        if(prev == target){ answer=Math.min(answer,count); return;}
        int temp = n;
        for(int i=0; i<8-count; i++){
            int nextCount = count + i+ 1;
            dfs(nextCount,prev+temp);
            dfs(nextCount,prev-temp);
            dfs(nextCount, prev*temp);
            dfs(nextCount,prev/temp);
            temp = temp*10 + n;
        }
    }
}
