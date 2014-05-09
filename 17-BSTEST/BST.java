public class BST{

    private Node root;
    public BST(){
	root = null;
    }

    public Node getRoot(){
	return root;
    }

    public void insert(Node n){
	if(root == null)
	    root = n;
	else{
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
    }


    public Node search1(int i){
	Node pointer = root;
	while(pointer.getData() != i && pointer != null){
	    if(pointer.getData() < i)
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

    public void delete(int x){
	Node parent = null;
	Node pointer = root;
	Node baby = null;
	while(pointer.getData() != x && pointer != null){
	    parent = pointer;
	    if(pointer.getData() < x)
		pointer = pointer.getRight();
	    else
		pointer = pointer.getLeft();
	}
	//1 or no child case
	if(pointer.getLeft() == null || pointer.getRight() == null){
	    if(pointer.getLeft() != null)
		baby = pointer.getLeft();
	    else
		baby = pointer.getRight();

	    if(x > parent.getData())
		parent.setLeft(baby);
	    else
		parent.setRight(baby);
	}else{
	    //Two children case
	    Node tmp = pointer.getLeft(); //go left once and then as far right as we can
	    while(tmp.getRight() != null)
		tmp = tmp.getRight();
	    if(tmp.getLeft() == null){
		//copy value over for when left is empty
		tmp.setRight(pointer.getRight());
		tmp.setLeft(pointer.getLeft());
		if(x > parent.getData())
		    parent.setRight(tmp);
		else
		    parent.setLeft(tmp);
	    }else{
		tmp.setRight(pointer.getRight());
		//only need to replace one value
		if(x > parent.getData())
		    parent.setRight(tmp);
		else
		    parent.setRight(tmp);
		//going down the left replacing the values
		while(tmp.getLeft() != null)
		    tmp = tmp.getLeft();
		tmp.setLeft(pointer.getLeft()); //only way I could get it to do the final replace
	    }
	}
	
    }

    public void traverse(){
	traverse(root);
    }

    public void traverse(Node n){
	if(n == null)
	    return;
	else{
	    System.out.println(n.getData());
	    traverse(n.getLeft());
	    traverse(n.getRight());
	}
    }

    public static void main(String[] arrrgs){
	BST a = new BST();
	a.insert(new Node(50));
	a.insert(new Node(47));
	a.insert(new Node(34));
	a.insert(new Node(40));
	a.insert(new Node(38));
	a.insert(new Node(39));
	a.insert(new Node(7));
	a.traverse();
    }
}


