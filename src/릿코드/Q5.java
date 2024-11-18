package 릿코드;

public class Q5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] isFit = new boolean[N][N];
        int retS=0;
        int retE=0;

        for(int i=0;i<N;i++){ isFit[i][i]=true; }
        for(int i=0;i<N-1;i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isFit[i][i + 1] = true;
                retS = i;
                retE = i + 1;
            }
        }

        for(int len=3; len<=N; len++){ // 3 이상의 길이별로
            for(int start=0; start+len<=N; start++){
                int end = start+len - 1;
                if(s.charAt(start)==s.charAt(end) && isFit[start+1][end-1]){
                    isFit[start][end]=true;
                    retS = start;
                    retE = end;
                    // System.out.println(s.substring(retS,retE+1));
                }
            }
        }
        return s.substring(retS,retE+1);
    }
}
