package double_linked_lists.wrongTry_double_chain_list_with_other;
public class DoubleLinkedList {

    private Element start;
    private Element end;
    private int size = 0;


    //Konstruktor
    public DoubleLinkedList() {
        start = new Element();
        end = new Element();
        start.nextElem = end;
        end.prevElem = start;
    }

    public void addLast(String e1) {

        //create new Element from Object e1
        Element add = new Element(e1);

        //Save last element in save
        Element save = end.prevElem;

        //change pevious Element to new Element add
        end.prevElem = add;

        // set previous Element from add to save
        add.prevElem = save;

        // set next Element from add to end
        add.nextElem = end;

        //change next Element from save to new Element add
        save.nextElem = add;

        //increase size Counter
        size++;
    }


    public void addBefore(String before, String e1) {

        // create Elements actual and saveBefore
        Element actual, saveBefore;

        //set actual to new Element e1
        actual = new Element(e1);

        //set saveBefore to first Element in List
        saveBefore = start.getNextElem();

        //loops through saveBefore, until Value is Null
        while (saveBefore != null) {

            //Check if the actual Element is the given from before
            if (saveBefore.getObj().equals(before)) {

                //set the previous Element from saveBefore to actual
                actual.setPrevElem(saveBefore);

                //set the Next Element, given from the previous element of saveBefore to actual
                saveBefore.getPrevElem().setNextElem(actual);

                //change the Previous Element  for saveBefore to actual
                saveBefore.setPrevElem(actual);

                //set next Element from Actual to saveBefore
                actual.setNextElem(saveBefore);

                //stop Loop
                break;
            }
            //check for next Element in saveBefore
            saveBefore = saveBefore.getNextElem();
        }
    }




    public void addAfter(String after, String e1) {
        Element actual, saveAfter, nextElement;
        nextElement = null;
        actual = new Element(e1);
        saveAfter = start.getNextElem();


        while ((saveAfter != null) && !(saveAfter.getObj().equals(after))) {
            saveAfter = saveAfter.getNextElem();
        }
        if (saveAfter != null) {
            nextElement = saveAfter.getNextElem();
            saveAfter.setNextElem(actual);
            actual.setNextElem(nextElement);
            actual.setPrevElem(saveAfter);
        }
        if (nextElement != null) {
            nextElement.setPrevElem(actual);
        }
    }




    public void output() {
        Element outputAll = start.getNextElem();
        while (outputAll.getNextElem() != null) {
            System.out.println("Das element hat den Wert: " + outputAll.getObj());
            outputAll = outputAll.nextElem;
        }
    }

}




