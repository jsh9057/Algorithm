package Toss;

public class n1 {
    public static void main(String[] args) {
        String s="12223";
        int len = s.length();
        boolean[] arr = new boolean[10];
        for(int i=1;i<len-1;i++){
            if( (s.charAt(i)==s.charAt(i-1))&& (s.charAt(i)==s.charAt(i+1))){
                arr[s.charAt(i)-'0']=true;
            }
        }
        int answer=-1;
        for(int i=9;i>=0;i--){
            if(arr[i]){ String ret=i+""; ret = ret.repeat(3); answer = Integer.parseInt(ret);
                System.out.println(answer);}
        }
        System.out.println(answer);
    }
}
