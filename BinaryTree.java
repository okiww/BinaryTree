class Node 
{ 
	String data; 
	Node left, right; 

	public Node(String d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class BinaryTree 
{ 
    private int total = 0;
	Node root; 

    /* find matching string */
	int getLevelUtil(Node node, String data, int level) 
	{
		if (node == null) 
			return 0; 
	    if (node.data.toLowerCase().contains(data.toLowerCase())) {
	        total = total + level;
	    }      
		int downlevel = getLevelUtil(node.left, data, level + 1); 
		downlevel = getLevelUtil(node.right, data, level + 1);
		
		return total; 
	} 

    /* get level Node */
    int getLevel(Node node, String data) 
	{ 
	   return getLevelUtil(node, data, 1);
	}
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 

        /* create tree */
		tree.root = new Node("z"); 
		tree.root.left = new Node("Y"); 
		tree.root.right = new Node("XY"); 

        /* string want be search */
        String search_string = "Y";
        int total = tree.getLevel(tree.root, search_string); 
        
 		System.out.println(total);
	} 
} 