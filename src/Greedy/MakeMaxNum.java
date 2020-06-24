package Greedy;

public class MakeMaxNum {
    public static void main(String args[]){
        String number="4177252841";
        int k=4;
        String answer="";
        int size = number.length();
        int select = size-k;
        int[] numberArr = new int[size];
        for(int i=0; i<size; i++)
            numberArr[i]=Integer.parseInt(String.valueOf(number.charAt(i)));

        int start=0;
        int end=k;

        while(select>0){
            int maxIndex = maxIndex(start,end,numberArr);
            answer += String.valueOf(numberArr[maxIndex]);
            start = maxIndex+1;
            select--;
            end= numberArr.length - select;
            if(select==start+1) {
                for (int i = start + 1; i < size; i++) {
                    answer += numberArr[i];
                }
                break;
            }
        }
        System.out.println(answer);
    }

    static int maxIndex(int start, int end, int[] arr){
        int max=arr[start];
        int maxIndex=start;
        for(int i =start; i<=end; i++) if(max<arr[i]){max=arr[i]; maxIndex=i;}
        return maxIndex;
    }
}
