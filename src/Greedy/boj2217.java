package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;



public class boj2217 {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int arr[] = new int[n];
		int max = 0;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			if(max<arr[i]*(n-i))
				max = arr[i]*(n-i);
		}
		System.out.println(max);
	}
}
