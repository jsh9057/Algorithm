package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class boj11399 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[n];
		int result = 0;
		for(int i=0;i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken())+arr[i];
		}
		Arrays.sort(arr);
		result = arr[0];
		for(int i=1; i<n; i++) {
			arr[i]=arr[i-1]+arr[i];
			result=arr[i]+result;
		}
		System.out.println(result);
	}

}
