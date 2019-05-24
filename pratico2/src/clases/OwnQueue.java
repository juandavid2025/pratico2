package clases;

//cola mas eficiente
public class OwnQueue <T>{

	private Object<T> first;
	private Object<T> last;
	private long elements;
	
	public OwnQueue() {
		elements=0;
	}
	
	public void offer(T element) {
		 Object<T> obj = new Object<T>(element);
		 if(first==null) {
			 first=obj;
			 last=obj;
			 elements++;
		 }
		 else {
			 obj.setNext(first);
			 first.setLast(obj);
			 first=obj;
			 elements++;
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	public T poll() {
		T element=null;
		 if(elements==1) {
			element= (T) first.getObject();
			first=null;
			last=null;
			elements--;
		} else{
			
			element= (T) last.getObject();
			last=last.getLast();
			last.setNext(null);
			elements--;
		}
		 return element;
	 }
	 
	 @SuppressWarnings("unchecked")
	public T peek() {
		 return (T) last.getObject();
	 }
	 
	 public boolean isEmpty() {
		 if(first==null) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 public long size() {
		 return elements;
	 }
	 
	 public void clean() {
		 first=null;
		 last=null;
		 elements=0;
	 }
}
