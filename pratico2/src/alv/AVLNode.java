package alv;

public class AVLNode <K extends Comparable<K>,T>{

	private K key;
	   private T element;
	   private AVLNode<K,T> father;
	   private AVLNode<K,T> right;
	   private AVLNode<K,T> left;
	   private boolean isRightSon;
	   private int charge;

	   public AVLNode(K key,T element) {
		   this.key=key;
		   this.element=element;
	   }
	   
	   public int getCharge() {
			return charge;
		}

		public void setCharge(int charge) {
			this.charge = charge;
		}
	   
	   public void setRightSon(boolean value) {
		   isRightSon=value;
	   }
	   
	   public boolean getIsRightSon() {
		   return isRightSon;
	   }
	   
	   public void setFather(AVLNode<K,T> father) {
		   this.father=father;
	   }
	   
	   public AVLNode<K,T> getFather(){
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

	public AVLNode<K, T> getRight() {
		return right;
	}

	public void setRight(AVLNode<K, T> right) {
		this.right = right;
	}

	public AVLNode<K, T> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<K, T> left) {
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

	   public AVLNode<K,T> deleteR(){
		   
		   if(leaf()) {
			   return null;
		   }
		   
		   if(right==null) {
			   return left;
		   }
		   else if(left==null) {
			   return right;
		   }
		   else {
			   //tiene los dos hijos
			   
			   AVLNode<K,T> sucesor = minValue(right);
			   
			   if(sucesor!=right && sucesor != left) {
				   if(sucesor.isRightSon) {
					   AVLNode<K,T> temp = sucesor.deleteR();
					   temp.setRightSon(true);
					   sucesor.getFather().setRight(temp);
				   }
				   else {
					   AVLNode<K,T> temp = sucesor.deleteR();
					   temp.setRightSon(false);
					   sucesor.getFather().setLeft(temp); 
				   }
			   }
			   else {
				   sucesor.setLeft(left);
			   }
			   
			   return sucesor;
		   }
		   
	   }
	   
	   public AVLNode<K,T> minValue(AVLNode<K,T> current) {
		   return current.getLeft()==null?current:minValue(current.getLeft());
	   }

	   public boolean leaf() {
		   if(right==null && left==null) {
			   return true;
		   }else {
			   return false;
		   }
	   }
	   
	   public int getHeight() {
		   
		   int height=0;
		   
		   if(left!=null || right!=null) {
			   
			   height=getHeightR(this);
			   
		   }
		  
		   return height;
	   }
	   
	   private int getHeightR(AVLNode<K,T> current) {
		   int height=0;
		   int right=0;
		   int left=0;
		   
		 
		   if(current.getRight()!=null && current.getRight()!=null) {
			   height += Math.max(getHeightR(current.getRight()), getHeightR(current.getLeft()));
		   }
		   else {
			   if(current.getRight()==null && current.getLeft()!=null) {
				   height+=getHeightR(current.getLeft());
			   }
			   else if(current.getLeft()==null && current.getRight()!=null) {
				   height+=getHeightR(current.getRight());
			   }
		   }
		   height++;
		   
		   return height;
	   }

}
