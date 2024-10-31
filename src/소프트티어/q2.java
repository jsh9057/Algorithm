package 소프트티어;
import java.io.*;
import java.util.*;

public class q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = split.length;
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        int status = 0;
        for(int i=0; i<N-1; i++){
            if(arr[i] < arr[i+1]){
                if(status<0){ System.out.println("mixed"); return; }
            }
            if(arr[i] > arr[i+1]){
                if(status>0){ System.out.println("mixed"); return; }
            }
            status = arr[i+1]-arr[i];
        }
        System.out.println(status>0? "ascending":"descending");
    }
}
