package linkedlist;

public class LinkedList<T> implements List<T>
{
	private Node<T> head = null;
	private Node<T> tail = null;
    private int size = 0;
    
    private Node getNode(int index){
    	Node<T> curr = head;
    	for(int i=0;i<index;i++){
    		curr=curr.getNext();
    	}
    	return curr;
    }
    
    private void boundsCheck(int index){
    	if(index<0||index>=this.size){
    		throw new IndexOutOfBoundsException("index "+index+" is out of bounds");
    	}
    }
    
    @Override
    public int size() {
    	return this.size;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNode(index);
        return node.getData();
    }

    @Override
    public void set(int index, T item) {
    	boundsCheck(index);
        Node<T> node = getNode(index);
        node.setData(item);
    }

    @Override
    public void add(T item) {
        this.size++;
        if(head==null){
        	head = new Node(item, null, null);
        	tail = new Node(null, head, null);
        	head.setNext(tail);
        }else{
        	Node<T> node = new Node(item, null, null);
        	
        	node.setNext(tail);
        	node.setPrev(tail.getPrev());
        	
        	tail.getPrev().setNext(node);
        	tail.setPrev(node);
        }
    }
    
    @Override
    public String toString() {
    	String res = "[ ";
    	Node<T> curr = head;
		for(int i=0;i<this.size;i++){
			res = res+curr.getData()+" ";
			curr=curr.getNext();
			
		}
		return res+"]";
    }

    @Override
    public void insert(int index, T item) {
    	if(index==0 && this.size==0){
    		head = new Node(item, null, null);
        	tail = new Node(null, head, null);
        	head.setNext(tail);
    	}else{
    		Node<T> node = getNode(index);
	    	Node<T> ins = new Node(item, null, null);
	    	
	    	ins.setNext(node);
	    	ins.setPrev(node.getPrev());
	    	
	    	node.getPrev().setNext(ins);
	    	node.setPrev(ins);
	    }
    	
    	this.size++;
    }

    @Override
    public void insertFirst(T item) {
    	if(this.size==0){
    		head = new Node(item, null, null);
        	tail = new Node(null, head, null);
        	head.setNext(tail);
    	}else{
	    	Node<T> ins = new Node(item, null, null);
	    	
	    	ins.setNext(head);
	    	head.setPrev(ins);
	    	
	    	head = ins;
	    }
    	
    	this.size++;
    }

    @Override
    public T remove(int index) {
    	boundsCheck(index);
    	this.size--;
    	if(index==0){
    		T val = head.getData();
    		head = head.getNext();
    		head.setPrev(null);
    		
    		return val;
    	}else{
	    	Node<T> node = getNode(index);
	    	T val = node.getData();
	    	
	    	node.getNext().setPrev(node.getPrev());
	    	node.getPrev().setNext(node.getNext());

	    	return val;
    	}
    }

    @Override
    public T removeFirst() {
    	this.size--;
    	T val = head.getData();
    	head = head.getNext();
    	head.setPrev(null);
    		
    	return val;
    }

    @Override
    public List<T> subList(int start, int end) {
    	LinkedList<T> list = new LinkedList<T>();
    	
    	boundsCheck(end);
    	boundsCheck(start);
    	Node<T> node = getNode(start);
    	
    	for(int i = start; i<end; i++){
    		list.add(node.getData());
    		node = node.getNext();
    	}
    	
    	return list;
    }

    @Override
    public List<T> subList(int index) {
    	LinkedList<T> list = new LinkedList<T>();
    	
    	boundsCheck(index);
    	
    	Node<T> node = getNode(index);
    	
    	for(int i = index; i<this.size; i++){
    		list.add(node.getData());
    		node = node.getNext();
    	}
    	
    	return list;
    }

    @Override
    public void add(List<T> other) {
    	for(int i=0;i<other.size();i++){
    		Node<T> node = new Node(other.get(i), null, null);
        	
        	node.setNext(tail);
        	node.setPrev(tail.getPrev());
        	
        	tail.getPrev().setNext(node);
        	tail.setPrev(node);
        	
        	this.size++;
		}
    }

    @Override
    public boolean contains(T item) {
    	Node<T> curr = head;
    	for(int i=0;i<this.size;i++){
    		if(curr.getData().equals(item)){
    			return true;
    		}
    		curr=curr.getNext();
    	}
    	return false;
    }

}
