package dfsAndbfs;


import java.util.*;

public class WordChange {

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();

        q.add(new Word(begin,0));

        while (!q.isEmpty()){
            Word now = q.poll();

            visit.add(now.word);
            if(target.equals(now.word)){ return now.depth; }

            for(String word :words){
                if(diffCount(word,now.word)==1 && !visit.contains(word)){
                    q.add(new Word(word,now.depth+1));
                }
            }
        }
        return 0;
    }

    public static int diffCount(String a, String b){
        int ret=0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)){ ret++; }
        }
        return ret;
    }

    static class Word{
        String word;
        int depth;

        public Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log"});
    }
}
