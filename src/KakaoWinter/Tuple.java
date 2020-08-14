package KakaoWinter;

import java.util.Arrays;
import java.util.StringTokenizer;


public class Tuple {
    public static void main(String args[]){
        String s="{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Tuple tuple = new Tuple();
        System.out.println(Arrays.toString(tuple.solution(s)));
    }

    public int[] solution(String s){
        s=s.substring(1,s.length()-1);
        StringTokenizer str = new StringTokenizer(s,"{}");

        int[][] list = new int[(str.countTokens()/2)+1][];
        int index1=0;

        while(str.hasMoreTokens()){
            String tmp = str.nextToken();
            if(!tmp.equals(",")) {
                StringTokenizer data = new StringTokenizer(tmp, ",");
                list[index1] = new int[data.countTokens()];
                int index=0;
                while (data.hasMoreTokens()) {
                    list[index1][index]=Integer.parseInt(data.nextToken());
                    index++;
                }
                index1++;
            }
        }
        Arrays.sort(list,(o1, o2) -> o1.length > o2.length ? 1:-1);

        int[] resultArr = new int[list.length];

        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[i].length; j++){
                int e = list[i][j];
                boolean exist = false;
                for(int k=0; k<=i; k++){ if(resultArr[k]==e){exist=true;} }
                if(!exist){resultArr[i]=e;}
            }
        }
        return resultArr;
    }
}
