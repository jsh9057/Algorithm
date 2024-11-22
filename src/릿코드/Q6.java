package 릿코드;

import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {
//        convert("PAYPALISHIRING",2);
        convert("A",1);
    }
    static int N,M;
    public static String convert(String s, int numRows) {
        N = numRows;
        M = s.length();
        if(numRows == 1){return s;}
        char[][] ret = new char[N][M];
        for(int i=0;i<numRows;i++){
            Arrays.fill(ret[i],' ');
        }
        int i=0;
        int y=0,x=0;
        while(i<M){
            while(true){
                if(i>=M){break;}
                ret[y][x] = s.charAt(i);
                if(y==N-1){ break;}
                y++;
                i++;
            }
            while(true){
                if(y==0){ break; }
                y--;
                x++;
                i++;
                if(i>=M){break;}
                ret[y][x] = s.charAt(i);
            }
        }
        String result = convert(ret,x);
        return result;
    }

    static void print(char[][] in){
        System.out.println(N+" "+M);
        for(int i=0 ; i<N ; i++){
            for (int j = 0; j < M ; j++) {
                System.out.print(in[i][j]);
            }
            System.out.println();
        }
    }
    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<=x && x<M; }
    static String convert(char[][] in, int lastX) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < lastX; j++) {
                if (in[i][j] == '0') {
                    sb.append(" ");
                } else {
                    sb.append(in[i][j]);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
