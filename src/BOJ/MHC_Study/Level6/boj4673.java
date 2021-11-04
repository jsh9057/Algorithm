package BOJ.MHC_Study.Level6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class boj4673 {
    public static void main(String args[])throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target=10000;
        boolean[] booleans=new boolean[target+1];
        int index=1;
        int res=0;

        while(index<=target){
            res=selfNumber(index);
            if(res>target){index++; continue;}
            booleans[selfNumber(index)]=true;
            index++;

        }
        for(int i=1;i<=target; i++){
            if(booleans[i]==false) bw.write(String.valueOf(i)+"\n");
        }
        bw.close();

    }
    public static int selfNumber(int n){
        String stringN = String.valueOf(n);
        int sum=n;
        for(int i=0; i<stringN.length(); i++){
            sum+=Integer.parseInt(String.valueOf(stringN.charAt(i)));
        }
        return sum;
    }
}
