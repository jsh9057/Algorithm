package naver;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		String record[] = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};

		List<String> buufer = new ArrayList<String>();
		List<String> answer = new ArrayList<String>();
		
		String commend;

		for(int i=0; i<record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i], " ");
			
			while(st.hasMoreTokens()) {
				commend=st.nextToken();
				if(commend.equals("RECEIVE")) {
					buufer.add(st.nextToken());
					break;
				}else if(commend.equals("DELETE")) {
					if(buufer.size()!=0)
						buufer.remove(buufer.size()-1);
					break;
				}else if (commend.equals("SAVE")) {
					answer.addAll(buufer);
					buufer.clear();
					break;
				}
			}
		}
		
		String result[] = new String[answer.size()];
		
		for(int i=0; i<answer.size(); i++) {
			result[i]=answer.get(i);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(result[i]);
		}
		
	}

}
