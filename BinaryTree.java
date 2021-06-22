package ds;
class TNode{
	int key;
	TNode left, right;
	
	public TNode(int key) {
		this.key=key;
		left=right=null;
	}
}
public class BinaryTree {

TNode root;
BinaryTree(int key){
	root= new TNode(key);
}
BinaryTree(){
	root=null;
}

static void preorder(TNode node) {
	if(node==null)
		return;
	System.out.println(node.key+" ");
	
	preorder(node.left);
	preorder(node.right);
}

static void inorder(TNode node) {
	if(node==null)
		return;
	inorder(node.left);
	System.out.println(node.key+ " ");
	inorder(node.right);
}
static void postorder(TNode node) {
	if(node==null)
		return;
	postorder(node.left);
	postorder(node.right);
	System.out.println(node.key+ " ");
}

static void spiralLevelOrder(TNode node) {
	int h=height(node);
	int i;
	boolean ltr=true;
	for(i=1;i<=h;i++) {
		printGivenLevel(node, i, ltr);
		ltr=!ltr;
	}
}

static int height(TNode node) {
	if(node==null) {
		return 0;
	}
	else {
		int lheight=height(node.left);
		int rheight=height(node.right);
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
	}
}

static void printGivenLevel(TNode node, int level, boolean ltr) {
	if(node==null)
		return;
	if(level==1)
		System.out.print(node.key+" ");
	else if(level>1)
	{
		if(ltr!=false) {
			printGivenLevel(node.left, level-1, ltr);
			printGivenLevel(node.right, level-1, ltr);
		}
		else {
			printGivenLevel(node.right, level-1, ltr);
			printGivenLevel(node.left, level-1, ltr);
		}
	}
}
public static void main(String [] args) {
	BinaryTree tree= new BinaryTree();
	tree.root= new TNode(1);
	tree.root.left= new TNode(2);
	tree.root.right= new TNode(3);
	tree.root.left.left=new TNode(4);
	tree.root.left.right=new TNode(5);
	//preorder(tree.root);
	
//			1
//		2		3
//	4		5
	spiralLevelOrder(tree.root);
}
}
