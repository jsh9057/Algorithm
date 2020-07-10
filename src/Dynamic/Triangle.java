package Dynamic;

public class Triangle {
    public static void main(String args[]){
//        int[][] triangle = {{7},{3,8},{8,3,0},{2,7,7,4},{4,5,2,6,5}};
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,6},{4,5,2,6,5}};
//        int[][] triangle = {{1},{2,3},{6,5,4},{7,8,9,10},{15,14,13,12,11},{16,17,18,19,20,21}};
        int answer=0;
        int level = triangle.length;
        int[][] sum = new int[level][level];
        sum[0][0]=triangle[0][0];
        if(level==1){answer = triangle[0][0];System.out.println(answer);return;}
        for(int i=1; i<level; i++){
            System.out.println("leng: "+triangle[i].length);
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){sum[i][j]=sum[i-1][j]+triangle[i][j];}
                else if(j==i){sum[i][j]=sum[i-1][j-1]+triangle[i][j];}
                else{
                    sum[i][j]=Math.max(sum[i-1][j-1],sum[i-1][j])+triangle[i][j];
                }
            }
        }


        for(int i=0; i<sum[level-1].length; i++){
            answer=Math.max(answer,sum[level-1][i]);
        }
        System.out.println(answer);
        for(int i=0; i<level; i++){
            for(int j=0; j<triangle[i].length; j++){

                System.out.print(sum[i][j]+" ");
            }
            System.out.println("");
        }
        for(int i=0; i<level; i++){
            for(int j=0; j<triangle[i].length; j++){

                System.out.print(triangle[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
