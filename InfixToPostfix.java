import java.util.*;
import java.lang.*;

class Stack{
    char stack[];
    int TOS = -1;

    Stack(){
        stack = new char[400];
    }

    void push(char op){
        TOS++;
        stack[TOS] = op;
    }

    char pop(){
        if(TOS==-1){
            return '0';
        }
        return stack[TOS--];
    }

    char onTop(){
        if(TOS==-1){
            return '0';
        }
        return stack[TOS];
    }

    void display(){
        for (int i = 0 ; i <= TOS ; i++) {
            System.out.println(stack[i]);
        }
    }
}

class Priority{
    int getPriority(char ch){
        switch (ch) {
            case '^':
                return 4;
            case '/':
                return 3;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 0;
        }
        return -1;
    }
}

class InfixToPostfix{
    static void displayPostfix(char arr[]){
        Stack stack = new Stack();
        int len = arr.length;
        Priority priority = new Priority();
        char temp;int limit = 100;

        for(int i = 0 ; i < len ; i++){
            if(Character.isLetter(arr[i])==true){
                System.out.print(arr[i]);
            }else if(arr[i]=='('){
                stack.push(arr[i]);
            }else if(arr[i]==')'){
                while(true){
                    temp = stack.pop();
                    if(temp=='(')break;
                    System.out.print(temp);
                }
            }else{
                while(true){
                    temp = stack.onTop();
                    if(temp=='('||temp=='0'){
                        stack.push(arr[i]);
                        break;
                    }
                    if(priority.getPriority(temp)>=priority.getPriority(arr[i])){
                        System.out.print(stack.pop());
                        continue;
                    }else stack.push(arr[i]);
                }
            }
        }
        char ch;
        while(true){
            ch = stack.pop();
            if(ch=='0')break;
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();

        for(int  i = 0 ; i < cases ; i++){
            String exp = sc.nextLine();
            char arr[];

            arr = exp.toCharArray();
            displayPostfix(arr);
            System.out.println();
        }
    }
}