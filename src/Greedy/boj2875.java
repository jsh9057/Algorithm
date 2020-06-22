package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2875 {
	public static void main(String args[]) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int g = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t=0;
		
		if(g+m>k) {
			if(g>=2*m) {
				t=m;
			}else {
				t=g/2;
			}
			k=k-((g+m)-(3*t));
			if(k>0) {
				t=t-(k+2)/3;
			}
		}
		System.out.println("t : "+t);
	}

}
