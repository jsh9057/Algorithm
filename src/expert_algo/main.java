package expert_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int[] An = new int[10000];
		StringTokenizer st;
		try {
			int T = Integer.parseInt(bf.readLine());
			
			for(int t=0; t<T ; t++) {
				result = 0;
				int n = Integer.parseInt(bf.readLine());
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j=0; j <n ; j++) {
					An[j]=Integer.parseInt(st.nextToken());
				}

				Arrays.sort(An,0,n);
				for(int j=0; j<n; j++) {
					result = result + An[j]+1;
				}
				result=result+An[n-1];
				System.out.println("#"+(t+1)+" "+result);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
