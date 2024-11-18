package 릿코드;

public class Q3163 {
    static final StringBuilder sb = new StringBuilder();
    public String compressedString(String word) {
        StringBuilder ret = new StringBuilder();
        int s = 0;
        int e = 0;
        char[] words = word.toCharArray();
        char now = words[0];
        while(e<words.length){
            if(words[e]==words[s]){ e++; }
            else {
                ret.append(compression(now, e-s));
                s = e;
                now = words[s];
            }
        }
        if(e!=s){
            ret.append(compression(now, e-s));
        }
        return ret.toString();
    }

    String compression(char c, int len){
        sb.setLength(0);
        int repeat = len/9;
        int remainder  = len%9;
        for(int i=0; i<repeat; i++){
            sb.append(9).append(c);
        }
        if(remainder > 0){ sb.append(remainder).append(c); }
        return sb.toString();
    }
}
