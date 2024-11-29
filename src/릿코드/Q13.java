package 릿코드;

public class Q13 {
    public int romanToInt(String s) {
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int ret = 0;
        for(int i=0;i<symbol.length;i++){
            if(s.length()==0){ break; }
            while(s.length()!=0 && s.startsWith(symbol[i])){
                ret+=value[i];
                s=s.substring(symbol[i].length(),s.length());
            }
        }
        return ret;
    }
}
