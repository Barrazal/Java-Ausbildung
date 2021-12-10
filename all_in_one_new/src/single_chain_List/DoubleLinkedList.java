public class DoubleLinkedList {

    private Element start;      //neue globale Variable des Typs Element
    private Element end;        //neue globale Variable des Typs Element
    private int size = 0;       // CounterVariable Global


    //Konstruktor
    public DoubleLinkedList() {
        start = new Element();
        end = new Element();
        start.nextElem = end;
        end.prevElem = start;
    }

    public void addLast(Object e1) {
        Element add = new Element(e1);
        Element save = end.prevElem;
        end.prevElem = add;
        add.prevElem = save;
        add.nextElem = end;
        save.nextElem = add;
        size++;
    }


    public void addBefore(Object before, Object e1) {
        Element actual, saveBefore;
        actual = new Element(e1);
        saveBefore = start.getNextElem();
        while (saveBefore != null) {
            if (saveBefore.getObj().equals(before)) {
                actual.setPrevElem(saveBefore);
                saveBefore.getPrevElem().setNextElem(actual);
                saveBefore.setPrevElem(actual);
                actual.setNextElem(saveBefore);
                break;
            }
            saveBefore = saveBefore.getNextElem();
        }
    }




    public void addAfter(Object after, Object e1) {
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




