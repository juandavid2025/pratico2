package alv;

public class OwnAVL<K extends Comparable<K>,T>{

	public AVLNode<K,T> root;
	
public void insert(K key,T element) {
		
		AVLNode<K,T> newNode = new AVLNode<K,T>(key,element);
		
		if(root == null) {
			
			// la raiz es nula
			
			root = newNode;
		}
		else {
			
			// la raiz no es nula	
			insertR(root,newNode);
		}
	}
	
	private void insertR(AVLNode<K,T> current,AVLNode<K,T> newNode) {
		
		if(current.compareTo(newNode.getKey())<0) {
			if(current.getRight()==null) {
				newNode.setFather(current);
				newNode.setRightSon(true);
				current.setRight(newNode);
			}
			else {
				insertR(current.getRight(),newNode);
			}
		}
		else {
			if(current.getLeft()==null) {
				newNode.setFather(current);
				newNode.setRightSon(false);
				current.setLeft(newNode);
			}
			else {
				insertR(current.getLeft(),newNode);
			}
		}
		
	}
	
	public void delete(K key) {
		
		//*******
		
		if(root!=null) {
			
			AVLNode<K,T> toDelete = getNode(key);
			
		     if(toDelete==root) {
		    	 //borrar raiz
		    	 
		    	root = root.deleteR();
		    	if(root!=null) {
		    	root.setFather(null);
		    	}
		    	 
		    	 //borrar raiz
		     }
		     else {
		    	 if(toDelete.getIsRightSon()) {
		    		 AVLNode<K,T> temp = toDelete.deleteR();
		    		 if(temp!=null) {
		    		 temp.setRightSon(true);
		    		 temp.setFather(toDelete.getFather());
		    		 }
		    		 toDelete.getFather().setRight(temp);
		    	 }
		    	 else {
		    		 AVLNode<K,T> temp = toDelete.deleteR();
		    		 if(temp!=null) {
		    		 temp.setRightSon(false);
		    		 temp.setFather(toDelete.getFather());
		    		 }
		    		 toDelete.getFather().setLeft(temp);
		    	 }
		    	 
		     }
		
		}	
		
	}
	
	private AVLNode<K,T> getNode(K key) {
		
		return getNodeR(root,key);
				
	}
	
	private AVLNode<K,T> getNodeR(AVLNode<K,T> node, K key){
		
		AVLNode<K,T> AVLNode = null; 
		
		if(node!=null) {
			
			if(node.compareTo(key)==0) {
				AVLNode=node;
			}
			else if(node.compareTo(key)<0) {
				
				AVLNode = getNodeR(node.getRight(),key);
				
			}else {
				
				AVLNode = getNodeR(node.getLeft(),key);
				
			}
			
		}
		
		return AVLNode;
		
	}
	
	public T search(K key) {
		T found=null;
		
		if(root!=null) {
			found=searchR(root,key);
		}
		
		return found;
	}
	
	private T searchR(AVLNode<K,T> node, K key) {
		T found=null;
		
		if(node!=null) {
			
			if(node.compareTo(key)==0) {
				found=node.getElement();
			}
			else if(node.compareTo(key)<0) {
				
				found=searchR(node.getRight(),key);
				
			}else {
				
				found = searchR(node.getLeft(),key);
				
			}
			
		}
		
		return found;
	}
	
	public boolean isEmpty() {
		if(root==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public String inOrder() {
		String in="";
		
		if(root!=null) {
		in += inOrderR(root);
		}
		return in;
	}
	
	private String inOrderR(AVLNode<K,T> current) {
		String in = "";
		
		if(current!=null) {
			
			in+=inOrderR(current.getLeft());
			in+=current.getElement();
			in+=inOrderR(current.getRight());
		}
		
		return in;
	}
	
	public String preOrder() {
        String pre="";
		
		if(root!=null) {
		pre += preOrderR(root);
		}
		return pre;
	}
	
	private String preOrderR(AVLNode<K,T> current) {
		
        String pre = "";
		
		if(current!=null) {
			
			pre+=current.getElement();
			pre+=preOrderR(current.getLeft());
			pre+=preOrderR(current.getRight());
			
		}
		
		return pre;
		
	}
	
	public String postOrder() {
		
        String pos="";
		
		if(root!=null) {
		pos += postOrderR(root);
		}
		return pos;
		
	}
	
	public String postOrderR(AVLNode<K,T> current) {
		
        String pos = "";
		
		if(current!=null) {
			
			pos+=preOrderR(current.getLeft());
			pos+=preOrderR(current.getRight());
			pos+=current.getElement();
			
		}
		
		return pos;
		
	}
	
	public void checkTree(AVLNode<K,T> start) {
		
		start.setCharge(0);
		checkTreeR(start.getFather());
	}
	
	public void checkTreeR(AVLNode<K,T> current) {
		
		
		
	}
	
	public void fix() {
		
	}
	
}
