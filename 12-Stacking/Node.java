public class Node{
    private String Data;
    private Node next;
    public Node(String d){
	Data = d;
	next = null;
    }
    public void setNext(Node n){
	next = n;
    }
    public void setData(String s){
	Data = s;
    }
    public Node getNext(){return next;}
    public String getData(){return Data;}
    public String toString(){
	return ""+getData();}
}