package linkedlist;
/**
 * @author jspacco
 *
 * @param <T>
 */
public class Node<T> {
  private T data;
  private Node<T> next;
  private Node<T> prev;
  
  public Node(T t){
    // fancy way to call a different constructor
    this(t, null, null);
  }
  
  public Node(T t, Node<T> prev, Node<T> next){
    this.data = t;
    this.prev = prev;
    this.next = next;
  }
  
  public T getData() {
    return this.data;
  }
  
  public Node<T> getNext() {
    return this.next;
  }
  
  public Node<T> getPrev() {
      return this.prev;
  }
  
  public void setData(T t){
    this.data = t;
  }
  
  public void setNext(Node<T> next){
    this.next = next;
  }
  
  public void setPrev(Node<T> prev){
      this.prev = prev;
  }
  
  public String toString() {
    return "node with data "+this.data.toString()+"";
  }
}