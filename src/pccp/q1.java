package pccp;

public class q1 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int[] timeLine = new int[1001];
        int cast = bandage[0];
        int hps = bandage[1];
        int add = bandage[2];
        int maxHp = health;
        int hp = health;
        int stack = 0;

        int lastAttack = 0;
        for(int[] a:attacks){ timeLine[a[0]]=a[1]; lastAttack = a[0]; }

        for (int i = 1; i <= lastAttack; i++) {
            if(timeLine[i]>0){
                hp -= timeLine[i];
                stack=0;
                if(hp<=0){return -1;}
            }
            else{
                stack++;
                hp+=hps;
                if(stack==cast){ hp+=add; stack=0; }
                hp = Math.min(hp,maxHp);
            }
        }
        return hp;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 4, 4}, 100, new int[][]{{1, 96}, {18, 1}}));
//        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
//        System.out.println( solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
//        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
//        System.out.println(solution(new int[]{1, 1, 1}, 20, new int[][]{{1, 5}, {4, 1}}));

    }
}
