package 소프트티어;
import java.util.*;
import java.io.*;
public class q6255 {
    static HashMap<Character,Integer> keyMap;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String M = br.readLine();
        String K = br.readLine();

        int len = K.length();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> mList = new ArrayList<>();
        for(char c:M.toCharArray()){ mList.add(c); }
        for(char c:K.toCharArray()){ list.add(c); }

        Character[][] key = new Character[5][5];
        HashSet<Character> set = new HashSet<>();
        int idx=0;
        for(int i=0; i<len; i++){
            Character c = list.get(i);
            if(!set.contains(c)){
                set.add(c);
                key[idx/5][idx%5]=c;
                idx++;
            }
        }


        for(Character c='A';c<='Z';c++){
            if(!set.contains(c) && c!='J'){
                set.add(c);
                key[idx/5][idx%5]=c;
                idx++;
            }
        }

        // for(int i=0;i<5;i++){
        //     for(int j=0; j<5;j++){
        //         System.out.print(key[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        keyMap = new HashMap<>();
        keyMapInit(key);

        idx = 1;
        ArrayList<ArrayList<Character>> cutList = new ArrayList<>();

        while(idx<mList.size()){
            Character c1 = mList.get(idx-1);
            Character c2 = mList.get(idx);

            if(c1 == c2){
                if(c1=='X'){ mList.add(idx,'Q'); }
                else { mList.add(idx,'X'); }
            }
            // System.out.println(mList.size()+", "+idx);
            // if(mList.size()-idx==2){
            //     mList.add(mList.size(),'X');
            //     break;
            // }
            idx+=2;
        }
        if(mList.size()%2==1){ mList.add('X'); }
        // System.out.println(mList);

        for(int i=1; i<mList.size(); i+=2){
            ArrayList<Character> tmp = new ArrayList<>();
            tmp.add(mList.get(i-1));
            tmp.add(mList.get(i));
            cutList.add(tmp);
        }
        // for(ArrayList<Character> l : cutList){
        //     System.out.println(l);
        // }

        StringBuilder sb = new StringBuilder();
        for(ArrayList<Character> l : cutList){
            int c1 = keyMap.get(l.get(0));
            int c1Y = c1/5;
            int c1X = c1%5;

            int c2 = keyMap.get(l.get(1));
            int c2Y = c2/5;
            int c2X = c2%5;

            // System.out.println(c1+","+c2);

            if(c1Y == c2Y){ // 같은 행
                c1X = (c1X+1)%5;
                c2X = (c2X+1)%5;
            }

            else if(c1X == c2X){ // 같은 열
                c1Y = (c1Y+1)%5;
                c2Y = (c2Y+1)%5;
            }
            else{ // 행,열 둘 다 다를 때
                int tmp=c1X;
                c1X = c2X;
                c2X = tmp;
            }
            sb.append(key[c1Y][c1X]).append(key[c2Y][c2X]);
        }
        System.out.println(sb);
    }

    static void keyMapInit(Character[][] key){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                keyMap.put(key[i][j],(i*5)+j);
            }
        }
    }

    // static int find(Character[][] arr, Character target){
    //     for(int i=0;i<25;i++){
    //         if(arr[i/5][i%5]==target){ return i; }
    //     }
    //     return -1;
    // }
}
