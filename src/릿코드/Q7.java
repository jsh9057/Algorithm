package 릿코드;

public class Q7 {
    static final long MIN = Integer.MIN_VALUE;
    static final long MAX = Integer.MAX_VALUE;
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        boolean isPlus = x>=0 ? true : false;
        if(!isPlus){sb.deleteCharAt(0);}
        sb.reverse();

        Long ret = Long.parseLong(sb.toString());
        ret = isPlus ? ret*1 : ret*-1;
        int intRet = 0;
        if(MIN<=ret && ret<=MAX){
            intRet = Integer.parseInt(sb.toString());
            intRet = isPlus ? intRet*1 : intRet*-1;
        }
        return intRet;
    }
}
