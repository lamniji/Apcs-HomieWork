import java.util.*;
public class ArrayStack{
    private String[] stack;
    private int top;
    public ArrayStack(){
	stack = new String[10];
	top = 0;
    }
    public String[] grow(String[] a){
	String[] ans = new String[a.length + 1];
	for(int i = 0; i < a.length; i++){
	    ans[i] = a[i];}
	return ans;
    }
    public String[] shiftRight(String[] a){
	String[] ans = new String[a.length];
	int c = 1;
	int i = 0;
	if(a[0] == null)
	    return a;
	else{
	    while(a[i] != null && i < a.length){
		ans[c] = a[i];
		c++;
		i++;
	    }
	}	
	return ans;
    }

    public String[] shiftLeft(String[] a){
	String[] ans = new String[a.length];
	int c = 0;
	int i = 1;
	while(a[i] != null && i < a.length){
	    ans[c] = a[i];
	    c++;
	    i++;
	}
	return ans;
    }

    public void push(String s){
	if(stack[stack.length - 1] != null){
	    grow(stack);
	}
	stack = shiftRight(stack);
	stack[0] = s;	
    }
    public String pop(){
	String ans =  stack[0];
	stack = shiftLeft(stack);
	return ans;
    }
    public String peek(){
	return stack[top];
    }
    public boolean isEmpty(){
	return stack[top] == null;
    }
    public int size(){
	int ans = 1;
	String[] temp = stack;
	int i = 0;
	while(temp[i] != null && i < stack.length -1){
	    ans++;
	    i++;
	}
	return ans;
    }
    public String toString(){
	return Arrays.toString(stack);
    }

    public static void main(String[] arrrgs){
	ArrayStack a = new ArrayStack();
	a.push("one");
	a.push("two");
	a.push("three");
	a.push("four");
	System.out.println(a.peek());
	a.push("five");
	a.push("six");
	System.out.println(a);
	a.push("seven");
	a.push("eight");
	a.push("nine");
	System.out.println(a);
	a.pop();
	System.out.println(a);
	a.push("ten");
	a.push("eleven");
	System.out.println(a);
	System.out.println(a.size());
    }
 

}
