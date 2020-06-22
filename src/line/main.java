package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int con = Integer.parseInt(st.nextToken());
		int que[] = new int[m];
		int c[] = new int[con];
		int mini = 100;
		int p = 0;

		for (int i = 0; i < m; i++) {
			que[i] = Integer.parseInt(bf.readLine());
		}
		for (int k = 0; k < m; k++) {
			mini = 100;
			for (int i = 0; i < con; i++) {
				if (c[i] < mini) {
					mini = c[i];
					p = i;
				}
			}
			c[p]=que[k]+c[p];
		}
		int max=0;
		for(int i= 0; i<con;i++) {
			if(max<c[i]) {
				max=c[i];
			}
		}
		System.out.println(max);
	}

}
