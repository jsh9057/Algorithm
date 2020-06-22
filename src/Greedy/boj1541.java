package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1541 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "-");
		String first = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(first,"+");
		int result=0;
		while(st2.hasMoreTokens()) {
			result+=Integer.parseInt(st2.nextToken());
		}
		if(st.hasMoreTokens()) {
			str = str.substring(first.length());
			String arr[]=str.split("\\+|-");
			for(int i=1; i<arr.length; i++) {
				result-=Integer.parseInt(arr[i]);
			}
		}
		System.out.println(result);
	}

}
