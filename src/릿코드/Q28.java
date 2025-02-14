package 릿코드;

public class Q28 {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            int hay = i;
            int idx = 0;
            while(needle.length()>idx && haystack.length()>hay
                    && haystack.charAt(hay)==needle.charAt(idx)){
                idx++;
                hay++;
            }
            if(idx==needle.length()){ return i; }
        }
        return -1;
    }
}
