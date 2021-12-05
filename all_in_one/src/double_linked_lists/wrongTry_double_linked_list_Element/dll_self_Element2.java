

package double_linked_lists.wrongTry_double_linked_list_Element;

public class dll_self_Element2<T> {

    private Node<T> start;
    private Node<T> end;
    private int size;
    private String listName;


    public dll_self_Element2(String listName) {
        start = new Node(null);
        end = new Node(null);
        start.nextNode = end;
        end.prevNode = start;
        size = 0;
        this.listName = listName;
    }

    private class Node<T> {
        private T value;
        private Integer nodeId;
        private String nodeName;
        private String nodeIsbn;
        private boolean nodeAvailable;
        private Node nextNode;
        private Node prevNode;

        public Node(T value) {
            nextNode = null;
            prevNode = null;
            this.value = value;
        }


        public Node() {
            //   this.value = null;
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


        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
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

        public void resetConnection() {
            this.prevNode = null;
            this.nextNode = null;
        }
    }


    public void add(Integer id) {
        Node newNode = new Node(id);
        Node saveNode = end.prevNode;
        end.prevNode = newNode;
        newNode.prevNode = saveNode;
        newNode.nextNode = end;
        saveNode.nextNode = newNode;

        size++;
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
                size++;
                break;

            }
            saveBefore = saveBefore.getNextNode();

        }
    }

    public void output() {
        Node outputAll = start.getNextNode();
        System.out.print("\n\n" + size + ", Bookcount: " + size);
        while (outputAll.getNextNode() != null) {
            System.out.print(outputAll.nodeOutput());
            outputAll = outputAll.nextNode;
        }
    }


    public void outputReverse() {
        Node outputReverse = end.getPrevNode();
        System.out.print("\n" + listName + ", Bookcount: " + size + "Reverse Output");
        while (outputReverse.getPrevNode() != null) {
            System.out.print(outputReverse.nodeOutput());
            outputReverse = outputReverse.prevNode;
        }
        System.out.println();
    }

    public void listLength() {
        System.out.println("\n" + listName + " has " + size + " Nodes in it´s Inventory");
    }

    public String seekList(Integer id) {

        Node seekList = start.getNextNode();
        System.out.print("\nSearch for id " + id + " in the List: " + listName);
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
        System.out.print("\nReverse Search for id " + id + " in the List: " + listName);
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

        for (int i = 0; i < size; i++) {
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
                this.size = localcount;
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
        size--;
    }


}
