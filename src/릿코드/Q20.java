package 릿코드;
import java.util.*;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if( c=='(' || c=='{' || c=='['){
                stack.add(c);
            }
            else{
                if(stack.isEmpty()){ return false; }
                Character p = stack.peek();
                if(p=='(' && c==')'){ stack.pop(); }
                else if(p=='{' && c=='}'){ stack.pop(); }
                else if(p=='[' && c==']'){ stack.pop(); }
                else{ return false; }
            }
        }
        if(!stack.empty()){ return false; }
        return true;
    }
}
