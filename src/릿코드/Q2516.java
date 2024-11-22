package 릿코드;

public class Q2516 {
    int[] abc;
    public int takeCharacters(String s, int k) {
        if(k==0){return 0;}
        abc = new int[3];
        for(int i=0;i<s.length();i++){
            abc[s.charAt(i)-'a']++;
        }
        if(!ifFit('a',0,k)){ return -1; }
        abc = new int[3];
        int start=0;
        int end = s.length()-1;
        for(end=s.length()-1; end>=0; end--){
            abc[s.charAt(end)-'a']++;
            if(ifFit('a',0,k)){ break; };
        }
        int min = start+(s.length()-end);
        // System.out.println(end);
        // System.out.println(min);
        while(start<s.length()){
            abc[s.charAt(start)-'a']++;
            while(true){
                if(end<s.length() && ifFit(s.charAt(end),-1,k)){
                    abc[s.charAt(end)-'a']--;
                    end++;
                }
                else{ break; }
            }
            min = Math.min(min,start+(s.length()-end)+1);
            // System.out.println(start+","+end+":"+min);
            start++;
        }
        return min;
    }
    boolean ifFit(char c, int add, int k){
        abc[c-'a']+=add;
        for(int i=0;i<3;i++){
            if(abc[i]<k){
                abc[c-'a']-=add;
                return false;
            }
        }
        abc[c-'a']-=add;
        return true;
    }
}
