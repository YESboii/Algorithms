package stack;

import java.util.Stack;

//very similar to I to Post
//reverse the expression
//convert it to postfix with criteria of only strictly < instead of =
public class InfixToPrefix {
    public static void main(String[] args) {
        infixToPrefix("(a+b)*c^d^e");
    }
    
    static void infixToPrefix(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb  = new StringBuilder(exp.length());
        StringBuilder expression = new StringBuilder(exp);
        expression.reverse();
        for (int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if (isOperand(ch)){
                sb.append(ch);
            }else if(ch == ')')
                stack.push(ch);
                else if (ch=='(') {
                while (!stack.isEmpty() && stack.peek()!=')'){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                while (!stack.isEmpty() && stack.peek()!=')'
                        &&precedence(ch) < precedence(stack.peek())) sb.append(stack.pop());
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb);
    }
    static boolean isOperand(char ch){
        return 'a'<=ch && ch<='z';
    }
    static int precedence(char ch){
        if(ch=='^') return 3;
        if(ch=='/' || ch == '*') return 2;
        return 1;
    }
}
