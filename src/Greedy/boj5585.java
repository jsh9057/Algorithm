package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj5585 {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int count = 0;
		int arr[] = { 500, 100,50, 10, 5, 1 };
		n=1000-n;
		for (int i = 0; i < arr.length; i++) {
			while (n >= arr[i]) {
				n=n-arr[i];
				count ++;
			}
		}
		System.out.println(count);
	}
}
