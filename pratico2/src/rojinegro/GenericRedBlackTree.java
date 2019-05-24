 package rojinegro;


public class GenericRedBlackTree <K extends Comparable<K>,T>{

	private RBTreeNode<K,T> root;
	
	public void insert(K key,T element) {
		
		RBTreeNode<K,T> newNode = new RBTreeNode<K,T>(key,element);
		
		if(root == null) {
			
			// la raiz es nula
			newNode.setRed(false); 
			root = newNode;
		}
		else {
			
			// la raiz no es nula	
			insertR(root,newNode);
		}
	}
	
	private void insertR(RBTreeNode<K,T> current,RBTreeNode<K,T> newNode) {
		
		if(current.compareTo(newNode.getKey())<0) {
			if(current.getRight()==null) {
				newNode.setFather(current);
				newNode.setIsRightSon(true);
				current.setRight(newNode);
				fixUpInsertion(newNode);
			}
			else {
				insertR(current.getRight(),newNode);
			}
		}
		else {
			if(current.getLeft()==null) {
				newNode.setFather(current);
				newNode.setIsRightSon(false);
				current.setLeft(newNode);
				fixUpInsertion(newNode);
			}
			else {
				insertR(current.getLeft(),newNode);
			}
		}
		
	}
	
	private void fixUpInsertion(RBTreeNode<K,T> newNode) {
		
		//caso2 --  papa rojo
		if (newNode.getFather().isRed()) {
			
			RBTreeNode<K,T> uncle = newNode.getUncle();
			if(uncle==null) {
				// papa rojo , tio negro nulo
				
				//caso linea
				if(newNode.getIsRightSon() && newNode.getFather().getIsRightSon()) {
					//linea confirmed
					
					
					
				}else if(!newNode.getIsRightSon() && !newNode.getFather().getIsRightSon()) {
					
					//linea confirmed
					
				}
				else {
					//triangulo
				}
				
			}
			else {
				
				if(uncle.isRed()) {
					//papa rojo , tio rojo
					
					newNode.getFather().setRed(false);
					uncle.setRed(false);
					newNode.getFather().getFather().setRed(true);
					fixUpInsertion(newNode.getFather().getFather());
					
				}else {
					//papa rojo, tio negro
					
					
				}
				
			}
			
			
		}
		//papa negro - no hago nada 
	}
	
	public void delete(K key) {
		
		//*******
		
		if(root!=null) {
			
			RBTreeNode<K,T> toDelete = getNode(key);
			
			if(toDelete==root) {
				
				
				
			}
			
			else if(toDelete.leaf()) {
				
				
				
			}
			
		}
		
	}
	
	private RBTreeNode<K,T> getNode(K key) {
		
		return getNodeR(root,key);
				
	}
	
	private RBTreeNode<K,T> getNodeR(RBTreeNode<K,T> node, K key){
		
		RBTreeNode<K,T> bstNode = null; 
		
		if(node!=null) {
			
			if(node.compareTo(key)==0) {
				bstNode=node;
			}
			else if(node.compareTo(key)<0) {
				
				bstNode = getNodeR(node.getRight(),key);
				
			}else {
				
				bstNode = getNodeR(node.getLeft(),key);
				
			}
			
		}
		
		return bstNode;
		
	}
	
	public T search(K key) {
		T found=null;
		
		if(root!=null) {
			found=searchR(root,key);
		}
		
		return found;
	}
	
	private T searchR(RBTreeNode<K,T> node, K key) {
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
	
	private String inOrderR(RBTreeNode<K,T> current) {
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
	
	private String preOrderR(RBTreeNode<K,T> current) {
		
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
	
	public String postOrderR(RBTreeNode<K,T> current) {
		
        String pos = "";
		
		if(current!=null) {
			
			pos+=postOrderR(current.getLeft());
			pos+=postOrderR(current.getRight());
			pos+=current.getElement();
			
		}
		
		return pos;
		
	}
	
}
