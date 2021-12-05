

package double_linked_lists.wrongTry_double_linked_list_Element;

public class dll_self_Element<T> {

   private Node <T> start;
   private Node <T> end;
   private int listCount = 0;


   public dll_self_Element() {
       start = new Node();
       end = new Node();
       start.nextNode = end;
       end.prevNode = start;

   }

   private class Node<T> {
       private T value;
       private Integer nodeId;
       private String nodeName;
       private String nodeIsbn;
       private boolean nodeAvailable;
       private Node nextNode;
       private Node prevNode;


       public Node() {
           //      this.value = null;
           this.nodeId = null;
           this.nodeName = null;
           this.nodeIsbn = null;
           this.nodeAvailable = false;
           this.nextNode = null;
           this.prevNode = null;
       }

       public Node(Integer id, String name, String isbn, boolean available) {
           //      this.value = null;
           this.nodeId = id;
           this.nodeName = name;
           this.nodeIsbn = isbn;
           this.nodeAvailable = available;
           this.nextNode = null;
           this.prevNode = null;
       }

       public Integer getNodeId() {
           return nodeId;
       }

       public Node getNextNode() {
           return nextNode;
       }

       public void setNextNode(Node nextNode) {
           this.nextNode = nextNode;
       }

       public Node getPrevNode() {
           return prevNode;
       }

       public void setPrevNode(Node prevNode) {
           this.prevNode = prevNode;
       }

       public String nodeOutput() {
           return "id: " + nodeId +
                   ", name: " + nodeName +
                   ", isbn: " + nodeIsbn +
                   ", available: " + nodeAvailable +
                   "";
       }
   }


   public void add(Integer id, String name, String isbn, boolean available) {
       Node newNode = new Node<T>(id, name, isbn, available);
       Node saveNode = end.prevNode;
       end.prevNode = newNode;
       newNode.prevNode = saveNode;
       newNode.nextNode = end;
       saveNode.nextNode = newNode;

       listCount++;
   }

   public void addBefore(Integer idBefore, Integer id, String name, String isbn, boolean available) {

       Node<T> saveBefore;
       Node newNode = new Node();

       saveBefore = start.getNextNode();


       while (saveBefore != null) {

           if (saveBefore.getNodeId().equals(idBefore)) {
               newNode.setPrevNode(saveBefore);
               saveBefore.getPrevNode().setNextNode(newNode);
               saveBefore.setPrevNode(newNode);
               newNode.setNextNode(saveBefore);
               listCount++;
               break;

           }
           saveBefore = saveBefore.getNextNode();

       }
   }

   public void output() {
       Node outputAll = start.getNextNode();
       System.out.print("\n\nBookcount: " + listCount);
       while (outputAll.getNextNode() != null) {
           System.out.print(outputAll.nodeOutput());
           outputAll = outputAll.nextNode;
       }
   }


   public void outputReverse() {
       Node outputReverse = end.getPrevNode();
       System.out.print("\nBookcount: " + listCount + "Reverse Output");
       while (outputReverse.getPrevNode() != null) {
           System.out.print(outputReverse.nodeOutput());
           outputReverse = outputReverse.prevNode;
       }
       System.out.println();
   }

   public void listLength() {
       System.out.println("\nhas " + listCount + " Nodes in it´s Inventory");
   }

   public String seekList(Integer id) {

       Node seekList = start.getNextNode();
       System.out.print("\nSearch for id " + id);
       if (seekList.nextNode != null) {
           while (seekList.getNodeId() != id) {
               seekList = seekList.getNextNode();
           }
           System.out.println(seekList.nodeOutput());
       }
       return null;
   }

   public String seekListReverse(Integer id) {

       Node seekListReverse = end.getPrevNode();
       System.out.print("\nReverse Search for id " + id);
       if (seekListReverse.prevNode != null) {
           while (seekListReverse.getNodeId() != id) {
               seekListReverse = seekListReverse.getPrevNode();
           }
           System.out.println(seekListReverse.nodeOutput());
       }
       return null;
   }

   public void delListAfter(Integer id) {
       Node actualNode = start.getNextNode();
       Node lastNode = end.getPrevNode().getNextNode();
       Node saveNext;
       int localcount = 0;
       id--;

       for (int i = 0; i < listCount; i++) {
           if (i < id) {
               actualNode = actualNode.getNextNode();
               localcount++;
           } else if (i == id) {
               saveNext = actualNode.getNextNode();
               actualNode.setNextNode(lastNode);
               lastNode.setPrevNode(actualNode);
               actualNode = saveNext;
               localcount++;
           } else if (i >= id && actualNode.getNextNode() != end) {

               saveNext = actualNode.getNextNode();
               saveNext.setPrevNode(null);
               actualNode.setNextNode(null);
               actualNode.setPrevNode(null);
               actualNode = saveNext;


           } else if (actualNode.getNextNode() == end) {
               this.listCount = localcount;
               return;
           }
       }
   }

   public void delete(Integer id) {
       Node actualNode = start.getNextNode();
       Node saveBefore;
       Node saveAfter;

       while (actualNode.getNodeId() != id && actualNode.getNextNode() != null) {
           actualNode = actualNode.getNextNode();
       }
       saveBefore = actualNode.getPrevNode();

       saveAfter = actualNode.getNextNode();

       actualNode.setNextNode(null);
       actualNode.setPrevNode(null);

       saveAfter.setPrevNode(saveBefore);

       saveBefore.setNextNode(saveAfter);
       listCount--;
   }


}
