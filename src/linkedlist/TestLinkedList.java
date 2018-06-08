package linkedlist;
import org.junit.Test;

//import linkedlist.sol.LinkedList;

import static org.junit.Assert.*;

/**
 * @author jspacco
 *
 */
public class TestLinkedList {
  @Test
  public void testEmptyList() {
      LinkedList<Integer> list = new LinkedList<Integer>();
      assertEquals(0, list.size());
  }
  
  @Test
  public void testAddToEmptyList() {
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.add(5);
      assertEquals(1, list.size());
  }
  
  @Test
  public void testGetFromListWithOne() {
      LinkedList<String> list = new LinkedList<String>();
      list.add("a");
      assertEquals("a", list.get(0));
  }
  
  @Test
  public void testAddTwo() {
      LinkedList<String> list = new LinkedList<String>();
      list.add("a");
      list.add("b");
      assertEquals(2, list.size());
      assertEquals("a", list.get(0));
      assertEquals("b", list.get(1));
  }
  
  @Test
  public void testEmpty() {
      LinkedList<String> list = new LinkedList<String>();
      assertEquals("[ ]", list.toString());
  }
  
  @Test
  public void testToString() {
      LinkedList<String> list = new LinkedList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      assertEquals("[ a b c ]", list.toString());
  }
  
  @Test
  public void testSet1() {
      LinkedList<String> list = new LinkedList<String>();
      list.add("a");
      list.add("b");
      list.set(0, "c");
      assertEquals(2, list.size());
      assertEquals("c", list.get(0));
      assertEquals("b", list.get(1));
  }
  
  @Test
  public void testSet2() {
      LinkedList<String> list = new LinkedList<String>();
      for (String s : new String[] {"a", "b", "c", "d", "e"}){
          list.add(s);
      }
      list.set(4, "z");
      assertEquals(5, list.size());
      assertEquals("a", list.get(0));
      assertEquals("b", list.get(1));
      assertEquals("c", list.get(2));
      assertEquals("d", list.get(3));
      assertEquals("z", list.get(4));
  }
  
  @Test
  public void testInsertEmpty() {
      LinkedList<String> list = new LinkedList<String>();
      list.insert(0, "a");
      assertEquals(1, list.size());
      assertEquals("a", list.get(0));
  }
  
  
  /**
   * Helper method for creating a LinkedList with 5 Strings, "0" through "4".
   * @return
   */
  private LinkedList<String> makeList() {
      return makeList(0, 5);
  }
  
  private LinkedList<String> makeList(int start, int end){
      LinkedList<String> list = new LinkedList<String>();
      for (int i=start; i<end; i++){
          list.add(i+"");
      }
      return list;
  }
  
  @Test
  public void testInsertMiddle() {
      LinkedList<String> list = makeList();
      assertEquals(5, list.size());
      
      list.insert(2, "a");
      assertEquals(6, list.size());
      
      assertEquals("a", list.get(2));
      
      assertEquals("0", list.get(0));
      assertEquals("1", list.get(1));
      
      assertEquals("2", list.get(3));
      assertEquals("3", list.get(4));
      assertEquals("4", list.get(5));
  }
  
  @Test
  public void testInsertEnd() {
      LinkedList<String> list = makeList();
      list.insert(5, "5");
      
      assertEquals(6, list.size());
      
      assertEquals("0", list.get(0));
      assertEquals("1", list.get(1));
      assertEquals("2", list.get(2));      
      assertEquals("3", list.get(3));
      assertEquals("4", list.get(4));
      assertEquals("5", list.get(5));
  }
  
  @Test
  public void testInsertFirst() {
      LinkedList<String> list = makeList();
      list.insertFirst("a");
      
      assertEquals(6, list.size());
      
      assertEquals("a", list.get(0));
      assertEquals("0", list.get(1));
      assertEquals("1", list.get(2));      
      assertEquals("2", list.get(3));
      assertEquals("3", list.get(4));
      assertEquals("4", list.get(5));
  }
  
  @Test
  public void testRemoveFirst() {
      LinkedList<String> list = makeList();

      String s = list.remove(0);
      
      assertEquals(4, list.size());
      
      assertEquals("0", s);
      
      assertEquals("1", list.get(0));
      assertEquals("2", list.get(1));      
      assertEquals("3", list.get(2));
      assertEquals("4", list.get(3));
  }
  
  @Test
  public void testRemoveLast() {
      LinkedList<String> list = makeList();

      String s = list.remove(4);
      
      assertEquals(4, list.size());
      
      assertEquals("4", s);
      
      assertEquals("0", list.get(0));
      assertEquals("1", list.get(1));      
      assertEquals("2", list.get(2));
      assertEquals("3", list.get(3));
  }


  
  @Test
  public void testSubList1() {
      List<String> list1 = makeList();
      List<String> list2 = list1.subList(1);
      
      assertEquals(5, list1.size());
      assertEquals(4, list2.size());
      
      assertEquals("1", list2.get(0));
      assertEquals("2", list2.get(1));
      assertEquals("3", list2.get(2));
      assertEquals("4", list2.get(3));
      
  }
  
  @Test
  public void testSubList2() {
      List<String> list1 = makeList();
      List<String> list2 = list1.subList(1, 3);
      
      assertEquals(5, list1.size());
      assertEquals(2, list2.size());
      
      assertEquals("1", list2.get(0));
      assertEquals("2", list2.get(1));
  }
  
  @Test
  public void testAddAll() {
      List<String> list1 = makeList();
      List<String> list2 = makeList(5, 10);
      list1.add(list2);
      
      assertEquals(10, list1.size());
      assertEquals(5, list2.size());
      
      for (int i=0; i<10; i++){
          assertEquals(i+"", list1.get(i));
      }
  }
  
  @Test
  public void testContainsFirst() {
      List<String> list1 = makeList();
      assertTrue(list1.contains("0"));
  }
  
  @Test
  public void testContainsSecond() {
      List<String> list1 = makeList();
      assertTrue(list1.contains("1"));
  }
  
  @Test
  public void testContainsLast() {
      List<String> list1 = makeList();
      assertTrue(list1.contains("4"));
  }
  
  @Test
  public void testNotContains() {
      List<String> list1 = makeList();
      assertFalse(list1.contains("77"));
  }
}