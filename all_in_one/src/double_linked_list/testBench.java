package double_linked_list;
public class testBench {
    public static void main(String[] args) {

    //    BookList shelf1 = new BookList("shelf1");
//
    //    shelf1.add(1, "DE-add2", "DE-123-GA412-fads3", true);
    //    shelf1.add(2, "DE-add1", "DE-123-GA412-fads3", true);
    //    shelf1.output();
//
    //    System.out.println();
    //    System.out.println();
//
    //    BookList shelf2 = new BookList("shelf2");
//
    //    shelf2.add(2, "AT-add2", "AT-123-GA412-fads3", true);
    //    shelf2.add(1, "AT-add1", "AT-123-GA412-fads3", true);
    //    shelf2.output();
//
    //    System.out.println();
    //    System.out.println();
//
    //    shelf1.addBefore(1, 3, "addbefore1", "DE-312-41asfd-51324AAA", true);
    //    shelf1.output();
//
    //    System.out.println();
    //    System.out.println();
//
    //    shelf2.addBefore(2, 3, "addbefore2", "AT-312-41asfd-51324AAA", true);
    //    shelf2.output();
//
    //    System.out.println();
    //    System.out.println();
//
    //    BookList shelf3 = new BookList("shelf3");
    //    shelf3.add(1, "outputReverse1", "DE-123-GA412-fads3", true);
    //    shelf3.add(2, "outputReverse2", "DE-123-GA412-fads3", true);
    //    shelf3.add(3, "outputReverse3", "DE-123-GA412-fads3", true);
    //    shelf3.add(4, "outputReverse4", "DE-123-GA412-fads3", true);
    //    shelf3.add(5, "outputReverse5", "DE-123-GA412-fads3", true);
    //    shelf3.add(6, "outputReverse6", "DE-123-GA412-fads3", true);
    //    shelf3.add(7, "outputReverse7", "DE-123-GA412-fads3", true);
    //    shelf3.add(8, "outputReverse8", "DE-123-GA412-fads3", true);
//
    //    shelf3.outputReverse();
//
    //    BookList shelf4 = new BookList("shelf4");
    //    shelf4.add(1, "listLength1", "DE-123-GA412-fads3", true);
    //    shelf4.add(2, "listLength2", "DE-123-GA412-fads3", true);
    //    shelf4.add(3, "listLength3", "DE-123-GA412-fads3", true);
    //    shelf4.add(4, "listLength4", "DE-123-GA412-fads3", true);
    //    shelf4.add(5, "listLength5", "DE-123-GA412-fads3", true);
//
    //    shelf4.listLength();
//
//
    //    shelf4.seekList(3);
//
    //    shelf3.seekListReverse(4);

        BookList shelf5 = new BookList("shelf5");
        shelf5.add(1, "delListAfter1", "DE-123-GA412-fads3", true);
        shelf5.add(2, "delListAfter2", "DE-123-GA412-fads3", true);
        shelf5.add(3, "delListAfter3", "DE-123-GA412-fads3", true);
        shelf5.add(4, "delListAfter4", "DE-123-GA412-fads3", true);
        shelf5.add(5, "delListAfter5", "DE-123-GA412-fads3", true);
        shelf5.add(6, "delListAfter6", "DE-123-GA412-fads3", true);
        shelf5.add(7, "delListAfter7", "DE-123-GA412-fads3", true);
        shelf5.add(8, "delListAfter8", "DE-123-GA412-fads3", true);
        shelf5.add(9, "delListAfter9", "DE-123-GA412-fads3", true);
        shelf5.add(10, "delListAfter10", "DE-123-GA412-fads3", true);
        shelf5.add(11, "delListAfter11", "DE-123-GA412-fads3", true);
        shelf5.add(12, "delListAfter12", "DE-123-GA412-fads3", true);
        shelf5.add(13, "delListAfter13", "DE-123-GA412-fads3", true);
        shelf5.add(14, "delListAfter14", "DE-123-GA412-fads3", true);
        shelf5.add(15, "delListAfter15", "DE-123-GA412-fads3", true);
        shelf5.add(16, "delListAfter16", "DE-123-GA412-fads3", true);


        shelf5.output();
        shelf5.delListAfter(7);
        shelf5.output();
        System.out.println();
        shelf5.outputReverse();


  //      System.out.println();
  //      System.out.println();
//
  //      BookList shelf6 = new BookList("shelf6");
  //      shelf6.add(1, "delete1", "DE-123-GA412-fads3", true);
  //      shelf6.add(2, "delete2", "DE-123-GA412-fads3", true);
  //      shelf6.add(3, "delete3", "DE-123-GA412-fads3", true);
  //      shelf6.add(4, "delete4", "DE-123-GA412-fads3", true);
  //      shelf6.add(5, "delete5", "DE-123-GA412-fads3", true);
  //      shelf6.add(6, "delete6", "DE-123-GA412-fads3", true);
  //      shelf6.add(7, "delete7", "DE-123-GA412-fads3", true);
  //      shelf6.add(8, "delete8", "DE-123-GA412-fads3", true);
//
  //      shelf6.delete(1);
  //      shelf6.delete(3);
  //      shelf6.delete(5);
  //      shelf6.delete(7);
  //      shelf6.output();
  //      shelf6.outputReverse();

    }

}
