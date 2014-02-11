
public class RedBlackBST<Key extends Comparable<Key>,Value> {

	private final static boolean RED=true;
	private final static boolean BLACK=false;
	
	public Node root=null;
	
	private class Node<Key extends Comparable<Key>,Value>{
		Key key;
		Value val;
		boolean color;
		Node left;
		Node right;
		
		Node(Key key, Value val){
			this.key=key;
			this.val=val;
			this.color=RED;
		}
	}
	
	/*Client methods*/
	public void put(Key key,Value val){
		root=put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val){
		if(x==null) x=new Node(key,val);
		
		int comp=x.key.compareTo(key);
		if(comp>0) x.left=put(x.left,key,val);
		if(comp<0) x.right=put(x.right,key,val);
		
		if(comp==0)x.val=val;
		
		if(!isRed(x.left) && isRed(x.right)) x=rotateLeft(x);
		if(isRed(x.left)&& isRed(x.left.left)) x=rotateRight(x);
		if(isRed(x.left)&& isRed(x.right)) flipColors(x);
		return x;
	}
	
	
	public Value get(Key key){
		return get(root,key);
	}
	
	private Value get(Node x, Key key){
		if(x==null) return null;
		Value ret=null;
		int comp=x.key.compareTo(key);
		if(comp<0) ret=get(x.left,key);
		else if(comp>0) ret=get(x.right,key);
		else ret=(Value) x.val;
		return ret;
	}
	
	/*Helper methods used by client methods*/
	
	private boolean isRed(Node x){
		if(x==null) return BLACK;
		return x.color==RED;
	}
	private Node rotateRight(Node x){
	
		Node temp=x;
		x=x.left;
		x.color=temp.color;
		temp.left=x.right;
		x.right=temp;
		x.right.color=RED;
		return x;
	}
	
	private Node rotateLeft(Node x){
		Node temp=x;
		x=x.right;
		x.color=temp.color;
		temp.right=x.left;
		x.left=temp;
		x.left.color=RED;
		
		return x;
	}
	
	private void flipColors(Node x){
		x.left.color=BLACK;
		x.right.color=BLACK;
		x.color=RED;
		return;
	}
	
	
	/*Methods for testing/debugging*/
	
	public Key getRoot(){
		return (Key)root.key;
	}
	
}
