public class MyLinkedList{
    private Node head;
    private Node holder;
    public MyLinkedList(){
	head = new Node("");
	 holder = head;
    }
    public String toString(){
	Node a = head;
	String ans = "";
	while(a.getNext()!=null){
	    ans +=  ""+a.getNext();
	    a = a.getNext();
	}
	return ans;
    }
    public void add(String d){
	Node tmp = new Node(d);
	holder.setNext(tmp);
	holder = holder.getNext();
    }
    public void add(int i, String s){
	boolean isDone = false;
	int index = 0;
	Node current = head.getNext();
	Node prior = head.getNext();
	while (! isDone){
	    if(index == i){
		Node fresh = new Node(s);
		prior.setNext(fresh);
		fresh.setNext(current);
		isDone = true;
	    }else{
		prior = current;
		current = current.getNext();
	    }
	    index++;
	}
    }
    public String get(int i){
	boolean isDone = false;
	Node current = head.getNext();
	int index = 0;
	String ans = null;
	while(! isDone){
	    if (i == index){
		isDone = true;
		ans = current.getData();
	    }else{
		current = current.getNext();
		index ++;
	    }
	}
	return ans;
    }

    public String remove(int i){
	boolean isDone = false;
	int index = 0;
	Node current = head.getNext();
	Node prior = head.getNext();
	String ans = null;
	while (! isDone){
	    if(index == i){
		ans = current.getData();
		prior.setNext(current.getNext());
		isDone = true;
	    }else{
		prior = current;
		current = current.getNext();
	    }
	    index++;
	}
	return ans;
    }

    public String set(int i, String s){
	boolean isDone = false;
	Node current = head.getNext();
	int index = 0;
	String ans = null;
	while(! isDone){
	    if (i == index){
		isDone = true;
		ans = current.getData();
		current.setData(s);
	    }else{
		current = current.getNext();
		index ++;
	    }
	}
	return ans;
    }

    public int find(String s){
	boolean isDone = false;
	Node current = head.getNext();
	int index = 0;
	int ans = 0;
	while(! isDone){
	    if (current.getData() == s){
		isDone = true;
		ans = index;
	    }else{
		current = current.getNext();
		index ++;
	    }
	}
	return ans;
    }

    public int length(){
	int length = 0;
	Node current = head.getNext();
	while(current.getNext() != null){
	    length++;
	    current = current.getNext();
	}
	return length;
    }



} 
