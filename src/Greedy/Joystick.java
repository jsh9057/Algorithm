package Greedy;

public class Joystick {
    public static void main(String args[]){
        String[] names = { "CANAAAAANAN", "AAAAACANAAAAANANAAAAAA", "JAN", "JEROEN", "BBAAAAA", "JJAJAAAAAAAAAJ",
                "AJAJAA", "BBABA", "BBBAAB", "BBAABAA", "BBAABBB", "BBAABAAAA", "BBAABAAAAB", "ABAAAAAAABA", "AAB",
                "AABAAAAAAABBB", "ZZZ", "BBBBAAAAAB", "BBBBAAAABA", "ABABAAAAAAABA", "BBBBBBBABB" ,"AZAAAZ"};

        int[] answers = { 48, 56, 23, 56, 3, 41, 21, 6, 8, 7, 10, 7, 10, 6, 2, 11, 5, 10, 12, 10, 18, 5 };

        for (int i = 0; i < names.length; i++) {
            int ret = sol(names[i]);  // 여기는 각자 코드에 맞게 수정하면 됩니다.
            if (ret != answers[i]){
                System.out.println("names[i]: " + names[i]);
                System.out.println("answers[i]: " + answers[i]);
                System.out.println("ret: " + ret + "\n");
            }
        }
    }

    public static int sol(String name) {
        int answer=0;
        int size = name.length();
        char[] charNameArr = new char[size];
        int notACount=0;
        for(int i=0; i< size ; i++){
            char v = name.charAt(i);
            charNameArr[i]=v;
            if(v!='A'){ answer+=minimumAlphabetCount(v); notACount++;}
        }
        System.out.println(answer);
        int index = 0;

        while (notACount>0){
            int length = nearbyALength(charNameArr,index);
            index=changeBack(index+length,size);
            charNameArr[index] = 'A';
            answer += Math.abs(length);
            notACount--;
        }
        return answer;
    }

    static int nearbyALength(char[] arr,int index){
        int size = arr.length;
        int checkCount = size-1;
        int length = 1;

        if(arr[index]!='A')
            return 0;

        while(checkCount>0){
            int right = changeBack(index+length,size);
            int left = changeBack(index-length,size);
            if(arr[right]!='A'){ return length; }
            else if(arr[left]!='A') {return -length;}
            checkCount--;
            length++;
        }
        return -9999;
    }
    static int changeBack(int num, int size){
        if(num < 0 ){return size+num;}
        else if(num>= size){return num-size;}
        else{return num;}
    }
    public static int minimumAlphabetCount(char c){
        int ret = ((int)c)-65;
        if(c<='N') { return ret; }
        else { return 26%ret; }
    }
}
