package study;

public class Cookie {
    public static int solution(int[] cookie) {
        int answer = 0;
        for (int m = 0; m < cookie.length-1; m++) {
            int i=m;
            int r=m+1;
            int iSum=cookie[i];
            int rSum=cookie[r];

            while (true){
                if(iSum==rSum){ answer = Math.max(answer,iSum);
                    if(i<1){ break; }
                    iSum+=cookie[--i];
                }
                else if(iSum<rSum){
                    if(i<1){ break; }
                    iSum+=cookie[--i];
                }
                else{
                    if(r==cookie.length-1){ break; }
                    rSum+=cookie[++r];
                }

            }
        }
        System.out.println(answer);
        return 0;
    }

    public static void main(String[] args) {
        solution( new int[]{1,1,1,1});
        solution( new int[]{1,1,2,3});
        solution( new int[]{1,2,4,5});
    }
}
