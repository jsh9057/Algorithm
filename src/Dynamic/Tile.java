package Dynamic;

public class Tile {
    public static void main(String args[]){
        int N = 80;
        long answer = 0;
        if(N==1){ answer=4;System.out.println(answer);return;}
        if(N==2){ answer=6;System.out.println(answer);return; }
        long n=2;
        long m=1;
        long tmp;
        for(int i=3; i<N; i++){
            tmp=n;
            n=n+m;
            m=tmp;
        }
        answer = (4*n) + (2*m);
        System.out.println(answer);
    }
}
