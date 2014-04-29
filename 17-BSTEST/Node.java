public class Node{

    private Node right;
    private Node left;
    private int data;

    public Node(int i){
	data = i;
	right = null;
	left = null;
    }
    
    public void setData(int i){
	data = i;
    }
    public int getData(){
	return data;
    }

    public void setLeft(Node n){
	left = n;
    }
    public Node getLeft(){
	return left;
    }

    public void setRight(Node n){
	right = n;
    }
    public Node getRight(){
	return right;
    }
}
