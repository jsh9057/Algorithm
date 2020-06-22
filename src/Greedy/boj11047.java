package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11047 {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int arr[] = new int [n];
		int count =0;
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(bf.readLine());
		}
		
		for(int i=n-1; i>=0; i--) {
			while(arr[i]<=money) {
				money=money-arr[i];
				count++;
			}
		}
		System.out.println(count);
	}
}
