package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    public static void main(String[] args){
        String begin= "hit";
        String target= "cog";
//        String[] words = {"cog","hot", "dot", "dog", "lot", "log"};
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog", "wow" };
//        String[] words = {"hhh","hht"} ;
        int answer;
        boolean[] visit= new boolean[words.length];
        System.out.println(bfs(begin,target,words,visit));


    }
//    public static int dfs(String begin, String target,int index, String[] words, boolean[] visit, int cnt){
//        if(begin.equals(target)){return cnt;}
//        if(visit[index]){return cnt;}
//        visit[index]=true;
//        int count = 0;
//        for(int i=0; i<words.length; i++){
//            if(isChange(begin,words[i])&&!visit[i] && index!=i){
//                count=dfs(words[i],target,i,words,visit,cnt+1);
//            }
//        }
//        return count;
//    }

    public static int bfs(String begin, String target, String[] words, boolean[] visit){
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<words.length; i++){
            if(isChange(begin,words[i])){
                q.add(i); visit[i]=true;
            }
        }

        int cnt=1;
        while(!q.isEmpty()){
            System.out.println("====="+cnt+"======");
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int n = q.poll();
                if(words[n].equals(target)){return cnt;}
                System.out.println(words[n]);
                for(int j=0; j<words.length; j++){
                    if(!visit[j] && isChange(words[n],words[j])){
                        q.add(j);
                        visit[j]=true;
                    }
                }
            }
            cnt++;
        }
        return 0;
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
