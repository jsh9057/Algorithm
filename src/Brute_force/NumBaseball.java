package Brute_force;

public class NumBaseball {
    public static void main(String args[]){
        int [][]baseball={{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        int answer=0;
        int length = baseball.length;
        int hitCount;

        for(int j = 123; j <= 987; j++) {
            hitCount = 0;
            for (int i=0; i<length ; i++)
                if (isUniqueNum(j) && is(j, baseball[i][0], baseball[i][1], baseball[i][2])) { hitCount++;}
            if(hitCount==length){answer++;}
        }
        System.out.println(answer);
    }

    public static boolean is(int num, int num2, int s, int b){
        String numString = String.valueOf(num);
        String numString2 = String.valueOf(num2);
        int strike=0;
        int ball=0;

        for(int i=0; i<3; i++)
            if(numString.charAt(i)==numString2.charAt(i)){ strike++; }
        if(s!=strike) {return false;}

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                if(i!=j && numString.charAt(i)==numString2.charAt(j)){ball++;}
        }

        if(b!=ball) {return false;}

        return  true;
    }

    public static boolean isUniqueNum(int num){
        String numString = String.valueOf(num);
        if(numString.charAt(0)=='0' || numString.charAt(0)==numString.charAt(1)){return false;}
        else if(numString.charAt(1)=='0' || numString.charAt(0)==numString.charAt(2)){return false;}
        else if(numString.charAt(2)=='0' || numString.charAt(1)==numString.charAt(2)){return false;}

        return true;
    }
}
