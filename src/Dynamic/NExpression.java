package Dynamic;

import java.util.*;

public class NExpression {
    public static void main(String args[]){
        int N=5;
        int number = 57;
        int sol = solution(N,number);
        System.out.println(sol);
    }

    static final int MAX_RANGE=32000;
    static final int MAX_N = 8;
    public static int solution(int N, int number) {
        int answer = 1;
        ArrayList<Set<Integer>> array= new ArrayList<>();
        int[] arr = new int[MAX_RANGE];
        arr[N]=1;
        for(int i=0 ; i<=MAX_N; i++){ array.add(new HashSet<>()); }

        array.get(1).add(N);
        int digit = 1;
        if(number == N)
            return 1;

        answer++;
        while (answer <= MAX_N) {
            digit += Math.pow(10,answer-1);
            Iterator it = array.get(answer-1).iterator();

            while (it.hasNext()){

                int n = (Integer) it.next();
                int sum = n + N;
                int sub = n - N;
                int div = n / N;
                int mul = n * N;

                if (isRange(sum) ) {
                    if(arr[sum]!=0){Math.min(arr[sum],answer);}
                    else if(arr[sum]==0){arr[sum]=answer;}
                    array.get(arr[sum]).add(sum);
                    if(sum==number){ return arr[sum];}
                }
                if (isRange(sub) ) {
                    if(arr[sub]!=0){Math.min(arr[sub],answer);}
                    else if(arr[sub]==0){arr[sub]=answer;}
                    array.get(arr[sub]).add(sub);
                    if(sub==number){ return arr[sub]; }
                }
                if (isRange(div)) {
                    if(arr[div]!=0){Math.min(arr[div],answer);}
                    else if(arr[div]==0){arr[div]=answer;}
                    array.get(arr[div]).add(div);
                    if(div==number){ return arr[div]; }
                }
                if (isRange(mul)) {
                    if(arr[mul]!=0){Math.min(arr[mul],answer);}
                    else if(arr[mul]==0){arr[mul]=answer;}
                    array.get(arr[mul]).add(mul);
                    if(mul==number){ return arr[mul]; }
                }
                if (isRange(digit*N)) {
                    if(arr[digit*N]!=0){Math.min(arr[digit*N],answer);}
                    else if(arr[digit*N]==0){arr[digit*N]=answer;}
                    array.get(arr[digit*N]).add(digit*N);
                    if(digit*N==number){ return arr[digit*N]; }
                }
            }

            for(int i=1; i<=answer; i++){
                Iterator iti = array.get(i).iterator();
                while(iti.hasNext()){
                    int n = (int) iti.next();
                    for(int j=1; j<=answer; j++){
                        Iterator itj =array.get(j).iterator();
                        while (itj.hasNext()){
                            int n2 = (int) itj.next();
                            int count = i+j;
                            int v;
                            if(count > MAX_N) {break;}
                            v=n+n2;
                            if(isRange(v)){
                                if(arr[v]==0){arr[v]=count; array.get(count).add(v);}
                                else{
                                    if(arr[v]>count){ arr[v]=count;array.get(count).add(v); }
                                }
                            }

                            v=n-n2;
                            if(isRange(v)) {
                                if (v > 0) {
                                    if (arr[v] == 0) { arr[v] = count;array.get(count).add(v); }
                                    else{
                                        if(arr[v]>count){ arr[v]=count;array.get(count).add(v); }
                                    }
                                }
                            }

                            v=n*n2;
                            if(isRange(v)) {
                                if (arr[v] == 0) { arr[v] = count;array.get(count).add(v); }
                                else{
                                    if(arr[v]>count){ arr[v]=count;array.get(count).add(v); }
                                }
                            }
                            v=n/n2;
                            if(isRange(v)) {
                                if (v > 0) {
                                    if (arr[v] == 0) { arr[v] = count;array.get(count).add(v); }
                                    else{
                                        if(arr[v]>count){ arr[v]=count;array.get(count).add(v); }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answer++;
        }
        return -1;
    }
    static boolean isRange(int n){
        if(n>0 && n<MAX_RANGE) {return true;}
        else {return false;}
    }
}
