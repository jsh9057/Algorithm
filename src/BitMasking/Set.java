package BitMasking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Set {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int bitMask =0;
        while(M-- >0){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            String op = st.nextToken();
            int n;

            switch (op){
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    bitMask = bitMask | 1<<(n-1);
                    break;

                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    bitMask = bitMask & ~(1<<(n-1));
                    break;

                case "check":
                    n = Integer.parseInt(st.nextToken());
                    sb.append(((bitMask & 1<<(n-1)) == 1<<(n-1) ? 1:0)+"\n");
                    break;

                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    bitMask = bitMask ^ 1<<(n-1);
                    break;

                case "all":
                    bitMask = ~0;
                    break;

                case "empty":
                    bitMask = 0;
                    break;

            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
