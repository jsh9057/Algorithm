package 릿코드;

public class Q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[] contain1 = new int[26];
        int[] contain2 = new int[26];

        int cnt = 0;
        for(int i=0;i<str1.length;i++){
            contain1[str1[i]-'a']+=1;
            contain2[str2[i]-'a']+=1;
            if(str1[i]!=str2[i]){ cnt++; }
        }

        if(cnt>2 || cnt==1){ return false; }
        for(int i=0;i<contain1.length;i++){
            if(contain1[i]!=contain2[i]){ return false; }
        }

        return true;
    }
}
