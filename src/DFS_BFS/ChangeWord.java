package DFS_BFS;

public class ChangeWord {
    public static void main(String[] args){
        String begin= "hit";
        String target= "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log","bog","cog"};
        int answer=51;
        for(int i=0; i<words.length; i++)
        {
            if(isChange(begin,words[i])){
                boolean[] visit = new boolean[words.length];
                System.out.println(dfs(words[i],target,i,words,visit,1));
            }
        }

    }
    public static int dfs(String begin, String target,int index, String[] words, boolean[] visit, int cnt){
        if(begin.equals(target)){return cnt;}
        if(visit[index]){return cnt;}
        visit[index]=true;
        int count = 0;
        for(int i=0; i<words.length; i++){
            if(isChange(begin,words[i])&&!visit[i] && index!=i){
                count=dfs(words[i],target,i,words,visit,cnt+1);
            }
        }
        return count;
    }

    public static boolean isChange (String begin, String target){
        int count =0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=target.charAt(i)){count++;}
        }
        if(count==1) {return true;}
        return false;
    }
}
