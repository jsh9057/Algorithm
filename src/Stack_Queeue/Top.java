package Stack_Queeue;



import java.util.Stack;

public class Top {
    public static void main(String arg[]) {
        int[] heights = {1,5,3,6,7,6,5};
        int[] answer = new int[heights.length];
        Stack<Integer> orgStack = new Stack<>();
        Stack<Integer> ansStack = new Stack<>();
        for (int i = 0; i < heights.length; i++)
            orgStack.push(heights[i]);

        for(int i=0; i<heights.length; i++){

            Stack<Integer> copyStack = (Stack<Integer>) orgStack.clone();
            for(int j=0; j<i; j++){
                copyStack.pop();
            }
            int size = copyStack.size();
            int nowTop = copyStack.pop();
            System.out.println("nowTop : "+nowTop);
            boolean isBigger = false;

            for(int j= 0; j<size; j++){
                if(copyStack.isEmpty()){
                    break;
                }
                int tmpTop = copyStack.peek();
               System.out.println("tmpTop: "+tmpTop);
                if(tmpTop>nowTop){
                    ansStack.add(copyStack.size());
                    copyStack.pop();
                    isBigger=true;
                    break;
                }else{
                    copyStack.pop();
                }
            }
            if(!isBigger){
                ansStack.add(0);
            }
        }
        int i =0;
        while(!ansStack.isEmpty()) {
            answer[i]= ansStack.pop();
            i++;
        }
    }
}
