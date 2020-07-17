package Dynamic;

public class Card {

    static int[][] score;
    static boolean[][] visit;

    public static void main(String args[]){
        int[] left = {1,8,9,1,1,1,1};
        int[] right= {8,9,3,3,3,3,3};
        score = new int[left.length][right.length];
        visit = new boolean[left.length][right.length];
        play(0,0, left, right);
        for(int i=0; i< left.length; i++){
            for(int j=0; j<right.length; j++){
                System.out.print(score[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int play(int l,int r, int[] left, int[] right){
        System.out.println("play("+l+" , "+r+")");
        if(l == left.length || r == right.length){
            System.out.println("l , r 둘중 하나 다 버림");
            return 0;
        }
        if(visit[l][r]==true) {
            System.out.println("이미 방문함");
            return score[l][r];
        }

        if(left[l]>right[r]){        //오른쪽 카드가 더 작을 경우
            int n1 = play(l, r + 1, left, right) + right[r];
            System.out.println("오른쪽만 버린경우 : "+n1);
            int n2 = play(l+1,r+1,left,right);
            System.out.println("둘다 버린경우: "+n2);
            if(n1>n2) {
                System.out.println("오른쪽카드만 버린경우 > 둘다 버린경우 ");
                score[l][r] =n1;                   // 오른쪽카드만 버린경우 : 점수 더하기
                System.out.println("l:"+l+ " r:"+r);
            }else{
                System.out.println("오른쪽카드만 버린경우 <= 둘다 버린경우");
                score[l][r]=n2;
                System.out.println("l:"+l+ " r:"+r);
            }
        }else{
            int n1=play(l+1,r,left,right);
            System.out.println("왼쪽 카드만 버린경우: "+ n1);
            int n2=play(l+1,r+1,left,right);
            System.out.println("둘 다 버린경우: "+n2);
            if(n1>n2){
                System.out.println("왼쪽카드만 버린경우 > 오른쪽카드만 버린경우");
                score[l][r]=n1;
            }else{
                System.out.println("왼쪽카드만 버린경우 <= 오른쪽카드만 버린경우");
                score[l][r]=n2;
            }
        }
        visit[l][r]=true;
        return score[l][r];
    }
}
