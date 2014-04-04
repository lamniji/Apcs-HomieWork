public class Driver{
    public static void main(String[] arrrgs){
	MyStack stack = new MyStack();
	stack.push("one");
	stack.push("two");
	stack.push("three");
	System.out.println(stack);
	System.out.print(stack.peek());
	while(stack.isEmpty() == false)
	    System.out.println(stack.pop());

    }
    
}