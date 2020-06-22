package Brute_force;

import java.util.*;

public class Decimal {
    static Set<Integer> set = new HashSet<Integer>();

    static void perm(char[] arr, char[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            setAdd(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static void setAdd(char[] arr, int r) {
        String value="";
        for (int i = 0; i < r; i++)
            value += arr[i];
        int v = Integer.parseInt(value);
        boolean isPrime =false;
        if(v>1){
            for(int i=2; i<v; i++){
                if(v%i==0){
                    isPrime=true;
                    break;
                }
            }
            if(!isPrime){
                set.add(v);
            }
        }
    }

    public static void main(String[] args){
        String numbers="17";
        int answer = 0;
        int n = numbers.length();
        char[]arr = new char[n];
        char[] out = new char[n];
        for(int i=0; i<n;i++)
            arr[i]=numbers.charAt(i);
        boolean[] visit = new boolean[n];

        for(int i=1; i<=n; i++)
            perm(arr, out, visit, 0, n,i);

        answer=set.size();
        for(Iterator i =set.iterator(); i.hasNext();)
            System.out.println(i.next());
    }
}
