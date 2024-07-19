package study;

import java.util.HashMap;

public class Autocomplete {
    static HashMap<Character, Word> wordMap;
    public static int solution(String[] words) {
        wordMap = new HashMap<>();
        for (String w: words){
            char c = w.charAt(0);
            if(wordMap.containsKey(c)){ wordMap.get(c).cnt++; }
            else { wordMap.put(c, new Word(c)); }
        }

        for (String w: words){
            Word now =  wordMap.get(w.charAt(0));
            for (int i = 1; i < w.length(); i++) {
                char c = w.charAt(i);
                if(now.child.containsKey(c)){ now.child.get(c).cnt++; }
                else{ now.child.put(c,new Word(c)); }
                now = now.child.get(c);
            }
        }
        int ret = 0;
        for (String w: words){
            Word now = wordMap.get(w.charAt(0));
            ret++;
            if( now.cnt==1 ){ continue; }
            for (int i = 1; i < w.length(); i++) {
                char c = w.charAt(i);
                now = now.child.get(c);
                ret++;
                if(now.cnt == 1){ break; }
            }
        }
        System.out.println(ret);
        return ret;
    }

    static class Word{
        char c;
        int cnt;
        HashMap<Character,Word> child;

        public Word(char c) {
            this.c = c;
            cnt = 1;
            child = new HashMap<>();
        }
    }
    public static void main(String[] args) {
        solution(new String[]{"go","gone","guild"});
        solution(new String[]{"abc","def","ghi","jklm"});
        solution(new String[]{"word","war","warrior","world"});
    }
}
