package line4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int arr[] = new int[n];
		int length = 0;
		int start = 0;
		int end = 0;
		
		int startDummy = 0;
		int endDummy = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (arr[0] == 0) {
			for (int i = 0; i < n; i++) {
				if(arr[i]==0) {
					startDummy++;
				}
				else break;
			}
		}
		if(arr[n-1]==0) {
			for(int i=n-1; n>i;i--) {
				if(arr[i]==0) {
					endDummy++;
				}
				else break;
			}
		}
		
		int sit[] = new int [n+startDummy+endDummy];
		int b=0; 
		for(int i=startDummy; i<sit.length-endDummy ; i++) {
			sit[i]=arr[b];
			b++;
		}
		
		double maxlength=0;
		
		for(int i=0; i<sit.length; i++) {
			if(sit[i]==1) {
				length=0;
			}
			else {
				length ++;
				if(length > maxlength) {
					maxlength = length;
				}
			}
		}
		int answer;
		if(maxlength%2==0) {
			answer = (int) ((maxlength/2)-1)+1;
		}
		else {
			answer = (int) Math.floor(maxlength/2)+1;
		}
		System.out.println(answer);

	}

}
