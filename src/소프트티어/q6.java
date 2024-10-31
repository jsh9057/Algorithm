package 소프트티어;
import java.io.*;
import java.util.*;
public class q6 {
    static final int[][] number = {
            //0
            {1,1,1,0,1,1,1},
            //1
            {0,0,1,0,0,1,0},
            //2
            {1,0,1,1,1,0,1},
            //3
            {1,0,1,1,0,1,1},
            //4
            {0,1,1,1,0,1,0},
            //5
            {1,1,0,1,0,1,1},
            //6
            {1,1,0,1,1,1,1},
            //7
            {1,1,1,0,0,1,0},
            //8
            {1,1,1,1,1,1,1},
            //9
            {1,1,1,1,0,1,1}
    };
    static final int[] empty = {0,0,0,0,0,0,0};

    static int[][] beforeArr = new int[5][7];
    static int[][] afterArr = new int[5][7];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            clearArr();
            String[] split = br.readLine().split(" ");
            setBefore(split[0]);
            setAfter(split[1]);
            int ret = cal();
            sb.append(ret).append("\n");
        }
        System.out.print(sb);
    }
    static void clearArr(){
        for(int i=0;i<5;i++){
            beforeArr[i] = empty;
            afterArr[i] = empty;
        }
    }
    static void setBefore(String b){
        int len = b.length();
        int tmp = 5-len;
        for(int i = 0; i<tmp; i++){ b="n"+b; }
        for(int i=0; i<5;i++){
            if(b.charAt(i)=='n'){
                beforeArr[i] = empty;
            }
            else{
                int n = Integer.parseInt(String.valueOf(b.charAt(i)));
                beforeArr[i] = number[n];
            }
        }
    }
    static void setAfter(String b){
        int len = b.length();
        int tmp = 5-len;
        for(int i = 0; i<tmp; i++){ b="n"+b; }
        for(int i=0; i<5;i++){
            if(b.charAt(i)=='n'){
                afterArr[i] = empty;
            }
            else{
                int n = Integer.parseInt(String.valueOf(b.charAt(i)));
                afterArr[i] = number[n];
            }
        }
    }
    static int cal(){
        int cnt = 0;
        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                if(beforeArr[i][j]!=afterArr[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
