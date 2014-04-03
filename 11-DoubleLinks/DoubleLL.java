//Eric Wong and Reda Lamniji
public class DoubleLL<E>{
    private class Node<E> {
	E data;
	Node<E> next, prev;
	public Node(E d) {
	    this.data = d;
	}
	public String toString() {
	    return ""+data;
	}
	public void setData(E d) {
	    data = d;
	}
	public E getData() {
	    return data;
	}
	public void setNext(Node<E> n) {
	    next = n;
	}
	public Node<E> getNext() {
	    return next;
	}
	public void setPrev(Node<E> p) {
	    prev = p;
	}
	public Node<E> getPrev() {
	    return prev;
	}
    }

    private Node<E> current;
    private Node<E> head;
    private Node<E> tail;

    public void insert(E d) {
	Node<E> n = new Node<E>(d);
	if (current==null) {
	    current=n;
	    head = current;
	}//for part 1
	   else if(current.getPrev() == null){
	    n.setNext(current);
	    current.setPrev(n);
	    current = n;
	    }else {
	    n.setNext(current);
	    n.setPrev(current.getPrev());
	    current.getPrev().setNext(n);
	    current.setPrev(n);
	    current = n;
	    lastOne();
	    tail.setNext(head);
	    head.setPrev(tail);
	}
    }
    public void lastOne(){
	Node<E> temp = head.getNext();
	while(temp.getNext()!=head){
	    temp = temp.getNext();
	}
	tail = temp;
    }
    public  E getCurrent() {
	return current.getData();
    }
    public void forward() {
	if (current.getNext() != null)
	    current = current.getNext();
    }
    public void back() {
	if (current.getPrev() != null)
	    current = current.getPrev();
    }
    public String toString() {
	if (current == null)
	    return "";
	/* for part 1
	while (current.getPrev() != null){
	    current = current.getPrev();
	    //System.out.println(current);
	}
	*/
	Node<E> tmp = head;
	String s = "";
	while (tmp.getNext() != null) {
	    s = s + tmp.getData() + " ";
	    //System.out.println(s);
	    tmp = tmp.getNext();
	}
	return s;
    }

    public static void main(String[] args) {
	DoubleLL<String> L = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("Three");
	System.out.println(L);
	//2nd Test//
	System.out.println(L.getCurrent());
	L.forward();
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
    }

}