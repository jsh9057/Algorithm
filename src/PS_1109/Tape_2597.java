package PS_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    문제의 제한조건이 문제 풀이의 큰 영향을 끼치지않고,
    최대 세번만 접으면 되기때문에 O(N) 의 시간복잡도를 갖고있어 단순구현이라고 판단.

    풀이
    빨간점 2,7
    파란점 4,5
    노란점 3,10
    1. 빨간점 a,b 를 반으로 접는다.
        - 반을 접는곳을 기준(4.5)
          4.5 를 초과하는 점들은 접고나서의 위치를 최신화 한다.
          파란점 a = 4.5-(5(파란점 a)-4.5)
          빨간점 b = 4.5-(7(빨간점 b)-4.5)
          ..

    2. 접는과정에서 다음 색깔 중 겹치는 색이있다면 체크하여 다음에 또 접지않는다.

 */
public class Tape_2597 {
    static double[][] point = new double[3][2]; // [색][0:start, 1:end]
    final static int RED = 0;
    final static int BLUE = 1;
    final static int YELLOW = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N  = Integer.parseInt(br.readLine());

        for(int i=0;i<3;i++){
            String[] in = br.readLine().split(" ");
            point[i][0]=Integer.parseInt(in[0]);
            point[i][1]=Integer.parseInt(in[1]);
        }

        for(int i=0;i<3;i++){
            if(point[i][0]==point[i][1]){ continue; }
            double half = getHalf(point[i][0],point[i][1]);
            update(half);
            N = Math.max(half,N-half);
            System.out.println("len:"+N);
            print();
        }
        System.out.println(String.format("%.1f",N));
    }

    static void print(){
        System.out.println("R:"+point[0][0]+", "+point[0][1]);
        System.out.println("B:"+point[1][0]+", "+point[1][1]);
        System.out.println("Y:"+point[2][0]+", "+point[2][1]);
        System.out.println("----------------------------------");
    }

    static double getHalf(double start, double end){ return (start + end)/2; }

    static void update(double half){
        double min = 0;
        for(double[] a : point){
            if(a[0]>half) { a[0]=half-(a[0]-half); min= Math.min(min,a[0]); }
            if(a[1]>half) { a[1]=half-(a[1]-half); min= Math.min(min,a[1]); }
        }
        if(min<0){
            min=min*-1;
            for(double[] a: point){
                a[0]+=min;
                a[1]+=min;
            }
        }
    }
}
