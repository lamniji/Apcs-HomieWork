public class BST{

    private Node root;
    public BST(){
	root = null;
    }

    public void insert(Node n){
	Node pointer = root;
	while (pointer != null){
	    if(pointer.getData() < n.getData())
		pointer = pointer.getRight();
	    else
		pointer = pointer.getLeft();
	}
	//Reached desired location
	pointer = n;
    }

    public Node search1(int i){
	Node pointer = root;
	while(pointer.getData() != i){
	if (pointer == null)
	    return pointer;
	else if(pointer.getData() < i)
	    pointer = pointer.getRight();
	else
	    pointer = pointer.getLeft();
	}
	return pointer;
    }

    public Node search2(Node c, int x){
	if (c == null)
            return null;
	//chose the right side to take equal values
        else if (x >= c.getData())
            return search2(c.getRight(), x);
        
        else if (x < c.getData())
            return search2(c.getLeft(), x);

        else    
            return null;
    }

}
