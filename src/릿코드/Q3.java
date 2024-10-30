package 릿코드;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> set = new HashMap<>();

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(!set.containsKey(s.charAt(i))){
                set.put(s.charAt(i),i);
                cnt++;
            }
            else {
                set.clear();
                i = set.get(s.charAt(i))+1;
                cnt=0;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        HashSet<Character> set = new HashSet<>();

        int max=0;
        int cnt=0;

        for (int i = 0; i < s.length(); i++) {
            if(!set.contains(s.charAt(i))){
                deque.addLast(s.charAt(i));
                set.add(s.charAt(i));
                cnt++;
            }
            else{
                while (true){
                    char c = deque.pollFirst();
                    set.remove(c);
                    cnt--;
                    if(c==s.charAt(i)){ break; }
                }
                deque.addLast(s.charAt(i));
            }
            max = Math.max(cnt,max);
        }

        return max;
    }

    public int lengthOfLongestSubstring3(String s){
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            else{
                set.add(s.charAt(right));
                max = Math.max(max, right-left+1);
            }

        }
        return max;
    }
}
