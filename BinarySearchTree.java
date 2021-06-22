package ds;

public class BinarySearchTree {
TNode root;
BinarySearchTree(){
	root=null;
}

TNode insert(TNode root, int key) {
	if(root==null) {
		root=new TNode(key);
		return root;
	}
	
	if(key<root.key)
		root.left= insert(root.left,key);
	else if(key>root.key)
		root.right= insert(root.right, key);
	
	return root;
}

void inorder(TNode root) {
	if(root!=null) {
		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);
	}
}

public static TNode search(TNode root, int key) {
	if(root==null||root.key==key)
		return root;
	if(root.key>key)
		return search(root.left,key);
	return search(root.right, key);
}

TNode delete(TNode root, int key) {
	if(root==null)
		return root;
	if(key<root.key)
		root.left=delete(root.left, key);
	else if(key>root.key)
		root.right=delete(root.right, key);
	
	else {
		if(root.left==null)
			return root.right;
		else if(root.right==null)
			return root.left;
		
		root.key=minValue(root.right);
		
		root.right= delete(root.right, root.key);
	}
	
	return root;
}

int minValue(TNode root) {
	int minValue=root.key;
	while(root.left!=null)
	{
		minValue= root.left.key;
		root=root.left;
	}
	return minValue;
}
public static void main(String []args) {
	BinarySearchTree tree= new BinarySearchTree();
	tree.root= tree.insert(tree.root, 1);
	tree.root= tree.insert(tree.root, 6);
	tree.root= tree.insert(tree.root, 3);
	tree.root= tree.insert(tree.root, 9);
	tree.root= tree.insert(tree.root, 2);
	tree.root= tree.insert(tree.root, 7);
		
	TNode present=search(tree.root, 6);
	if(present!=null)
		System.out.println("The number is present in the tree");
	else
		System.out.println("Number not present");
	
	tree.delete(tree.root, 6);
	tree.inorder(tree.root);
	
}
}
