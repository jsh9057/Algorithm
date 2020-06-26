package Greedy;

public class Joystick {
    public static void main(String args[]){
        String[] names = { "CANAAAAANAN", "AAAAACANAAAAANANAAAAAA", "JAN", "JEROEN", "BBAAAAA", "JJAJAAAAAAAAAJ",
                "AJAJAA", "BBABA", "BBBAAB", "BBAABAA", "BBAABBB", "BBAABAAAA", "BBAABAAAAB", "ABAAAAAAABA", "AAB",
                "AABAAAAAAABBB", "ZZZ", "BBBBAAAAAB", "BBBBAAAABA", "ABABAAAAAAABA", "BBBBBBBABB" };

        int[] answers = { 48, 56, 23, 56, 3, 41, 21, 6, 8, 7, 10, 7, 10, 6, 2, 11, 5, 10, 12, 10, 18 };

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
        int notACount=0 ;
        for(int i=0; i< size ; i++){
            char v = name.charAt(i);
            charNameArr[i]=v;
            if(v!='A'){ answer+=minimumAlphabetCount(v);}
        }

        int index= 0;
//        while (notACount>0){
//           if(charNameArr[index]=='A'){
//                int ALength = searchNotALength(charNameArr,index,size);
//                int move =0;
//                if(ALength>0) {move = ALength;}
//                else if(ALength<0) {move = -ALength;}
//                index = changeBack(index+ALength,size);
//                answer += move;
//            }
//            answer += minimumAlphabetCount(charNameArr[index]);
//            notACount--;
//            charNameArr[index]='A';
//        }
        answer +=notALength(charNameArr,index,size);
        System.out.println("이동: "+notALength(charNameArr,index,size));
        return answer;
    }

    static int notALength(char[] arr,int index, int size){
        int forCount = (int) Math.ceil((double) size/(double) 2);
        int rLength=0;
        int lLength=0;
        for(int i=1; i<size; i++) {
            int front = changeBack(index + i,size);
            int real = changeBack(index-i,size);
            if(arr[front]!='A') {rLength = i;}
            if(arr[real]!='A') {lLength = i;}
        }
        if (rLength>lLength)
            return (lLength*2) + rLength;
        else if(rLength < lLength)
            return (rLength*2)+ lLength;
        else return (rLength*2);
    }
    static int searchNotALength(char[] arr,int index, int size){
        int forCount = (int) Math.ceil((double) size/(double) 2);
        for(int i=1; i<forCount; i++){
            int front = changeBack(index + i,size);
            int real = changeBack(index-i,size);
            if(arr[front]!='A'&&arr[real]!='A'){
                char[] clone = arr.clone();
                clone[front]='A';
                clone[real] = 'A';
                int rSearch= searchNotALength(clone,front,size);
                int lSearch= searchNotALength(clone,real,size);
                lSearch = Math.abs(lSearch);
                return (rSearch>=lSearch) ? i : -i;
            }
            if(arr[real]!='A') {return -i;}
            if(arr[front]!='A') {return i;}
        }
        return 99999;
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
