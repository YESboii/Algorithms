package stack;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        infixToPostfix("(a+b)*(c-d)");
    }

    static void infixToPostfix(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch=='(') stack.push(ch);
            else if(ch==')'){
                while(stack.peek()!='(') sb.append(stack.pop());

                stack.pop();//'('
            } else if (isOperand(ch)) {
                sb.append(ch);
            }else{
                while(!stack.isEmpty() && stack.peek()!='(' && precedence(stack.peek())>=precedence(ch)){
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
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
