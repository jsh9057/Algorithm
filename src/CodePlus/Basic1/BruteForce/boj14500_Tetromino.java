package CodePlus.Basic1.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14500_Tetromino {

    static int[][][] poly = {
            { {0,0}, {0,1}, {1,0}, {1,1} }, // ㅁ
            { {0,0}, {0,1}, {0,2}, {0,3} }, // ㅡ
            { {0,0}, {1,0}, {2,0}, {3,0} },
            { {0,0}, {0,1}, {0,2}, {1,0} }, // ㄴ
            { {0,2}, {1,0}, {1,1}, {1,2} },
            { {0,0}, {1,0}, {1,1}, {1,2} },
            { {0,0}, {0,1}, {0,2}, {1,2} },
            { {0,0}, {1,0}, {2,0}, {2,1} },
            { {0,0}, {0,1}, {1,1}, {2,1} },
            { {0,0}, {0,1}, {1,0}, {2,0} },
            { {0,1}, {1,1}, {2,0}, {2,1} },
            { {0,0}, {1,0}, {1,1}, {2,1} }, // Z
            { {0,1}, {1,0}, {1,1}, {2,0} },
            { {0,1}, {0,2}, {1,0}, {1,1} },
            { {0,0}, {0,1}, {1,1}, {1,2} },
            { {0,0}, {0,1}, {0,2}, {1,1} }, // ㅗ
            { {0,1}, {1,0}, {1,1}, {1,2} },
            { {0,1}, {1,0}, {1,1}, {2,1} },
            { {0,0}, {1,0}, {1,1}, {2,0} }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N=Integer.parseInt(input[0]);      // 세로
        int M=Integer.parseInt(input[1]);      // 가로
        int[][] arr = new int [N][M];
        for(int n=0; n<N; n++){
            String[] str = br.readLine().split(" ");
            for(int m=0; m<M; m++){
                arr[n][m]=Integer.parseInt(str[m]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                for(int i=0;i<19; i++){
                int cost = 0;
                for(int j=0; j<4; j++){
                    int y = poly[i][j][0]+n; // y
                    int x = poly[i][j][1]+m; // x
                    if(y<N && x<M){
                        cost += arr[y][x];
                    }
                }
                if(max<cost){ max=cost; }
                }
            }
        }
        System.out.println(max);
    }

}
