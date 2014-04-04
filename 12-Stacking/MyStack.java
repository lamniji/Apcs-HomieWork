public class MyStack{
    private Node top;
    //constructor 1
    public MyStack(){
	top = null;
    }
    public void push(String s){
	Node tmp = new Node(s);
	tmp.setNext(top);
	top = tmp;
}

    public String toString(){
	String s = "";
	Node tmp = top;
	while(tmp != null){
	    s += tmp.getData() + ", ";
	    tmp = tmp.getNext();
	}
	return s;
    }
    public String pop(){
	String s = top.getData();
	top = top.getNext();
	return s;
    }
    
    public String peek(){
	return top.getData();
    }

    public boolean isEmpty(){
	return top == null;
    }
}