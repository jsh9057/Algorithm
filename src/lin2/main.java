package lin2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

	public static int c = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[st.countTokens()];
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        int num = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        perm(arr, output, visited, 0, n, num);
        System.out.println();
    }
    
    static void merge(int[] arr, int n, int num) {
       StringBuilder sb = new StringBuilder();
        String test = null;
        
        for (int i = 0; i < n; i++)
            test = String.valueOf(sb.append(arr[i]));
        if (c == num) {
            System.out.println(test);
        }
        c++;
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int num) {
        if (depth == n) {
           
        	merge(output, n, num);
            return;
        }

        for (int i = 0; i < n; i++) {
           
        	if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, num);
                visited[i] = false;
            }
        }
    }

}
