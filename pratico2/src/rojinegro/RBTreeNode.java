package rojinegro;

public class RBTreeNode <K extends Comparable<K>,T>{

	   private K key;
	   private T element;
	   private RBTreeNode<K,T> father;
	   private RBTreeNode<K,T> right;
	   private RBTreeNode<K,T> left;
	   private boolean isRightSon;
	   private boolean red;
	   private boolean doubleBlack;
	   
	   public RBTreeNode(K key,T element) {
		   this.key=key;
		   this.element=element;
		   this.red=true;
	   }
	   
	   public boolean isRed() {
		   return red;
	   }
	   
	   public void setRed(boolean newValue) {
		   red=newValue;
	   }  
	   
	   public boolean isDobleBlack() {
		return doubleBlack;
	   }

	   public void setDobleBlack(boolean dobleBlack) {
		this.doubleBlack = dobleBlack;
	   }

	   public void setIsRightSon(boolean value) {
		   isRightSon=value;
	   }
	   
	   public boolean getIsRightSon() {
		   return isRightSon;
	   }
	   
	   public void setFather(RBTreeNode<K,T> father) {
		   this.father=father;
	   }
	   
	   public RBTreeNode<K,T> getFather(){
		   return father;
	   } 
	   
	   public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public RBTreeNode<K,T> getRight() {
		return right;
	}

	public void setRight(RBTreeNode<K,T> right) {
		this.right = right;
	}

	public RBTreeNode<K,T> getLeft() {
		return left;
	}

	public void setLeft(RBTreeNode<K,T> left) {
		this.left = left;	
	}

	public int compareTo(K k) {

			
			if(key.compareTo(k)==0) {
			return 0;	
			}
			else if(key.compareTo(k)<0) {
				
				return -1;
			
			}else {
				return 1;
			}	
		
	}

	   public RBTreeNode<K,T> minValue(RBTreeNode<K,T> current) {
		   return current.getLeft()==null?current:minValue(current.getLeft());
	   }
	   
	   private RBTreeNode<K,T> deleteR(RBTreeNode<K,T> root, K key) {
		   
		   if(root==null) {
			   return root;
		   }
		   if(root.compareTo(key)>0) {
			   root.left=deleteR(root.left,key);
		   }
		   else if(root.compareTo(key)<0) {
			   root.right=deleteR(root.right,key);
		   }
		   else {
			   
			   if(root.left==null) {
				   return root.right;
			   }
			   else if(root.right==null) {
				   return root.left;
			   }
			   
			   root.key=minValue(root.right).getKey();
			   root.right= deleteR(root.right,root.key);
		   }
		   return root;
	   }
	   
	   public boolean leaf() {
		   if(right==null && left==null) {
			   return true;
		   }else {
			   return false;
		   }
	   }
	   
	   public RBTreeNode<K,T> getUncle() {
		   
		   RBTreeNode<K,T> temp = null;
		   
		   if(getFather().isRightSon) {
          	  temp=getFather().getFather().getLeft(); 
		   }
		   else {
			   temp=getFather().getFather().getRight();
		   }
		   
		   return temp;
	   }
	   
	   public void rightRotate() {
		   
	   }
	   
	   public void leftRotate() {
		   
	   }
	
}
