import java.util.*;
public class RPN{
    private BetterStack stack = new BetterStack();
    private int current;
    private BetterStack compblock = new BetterStack();
    
    public String Calculate(String s){
	if(compblock.size() == 1)
	    return s;
	for(int i = 0; i < s.length();i++){
	    String tmp = "";
	    if(s.charAt(i) != ' ')
		tmp += s.charAt(i);
	    else
		stack.push(tmp);
	}
	while(stack.peek().equals("+") && stack.peek().equals("-") && stack.peek().equals("*") && stack.peek().equals("/") && stack.peek().equals(null))
	    compblock.push(stack.pop());
	String tmp = stack.pop();
	    if(tmp == "+"){
		int a = ( Integer.parseInt(compblock.pop()) + (Integer.parseInt(compblock.pop())) );
		compblock.push(Integer.toString(a));
	    }else if(tmp == "-"){
		int a = ( ( Integer.parseInt(compblock.pop() ) ) + ( ( Integer.parseInt(compblock.pop() ) ) * -1 ) );
		compblock.push(Integer.toString(a));
	    }else if(tmp == "*"){
		int a = ( Integer.parseInt(compblock.pop()) * Integer.parseInt(compblock.pop()) );
		compblock.push(Integer.toString(a));
	    }else if(tmp == "/"){
		int a = ( Integer.parseInt(compblock.pop()) * ( 1 / ( Integer.parseInt(compblock.pop()) ) ) );
		compblock.push(Integer.toString(a));
	    }
	    return Calculate(compblock.toString());   	
    }

    public static void main(String[] arrgs){
	RPN a = new RPN();
	Scanner scan = new Scanner(System.in);
	System.out.println("What do you want?\n");
	String arg = scan.nextLine();
	//a.Calculate(arg);
	System.out.println(a.Calculate(arg));
	}


}
