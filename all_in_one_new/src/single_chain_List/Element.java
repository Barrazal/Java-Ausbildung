public class Element {
    Object obj;
    Element nextElem, prevElem;

    public Element(){
        this.obj = null;
        this.nextElem = null;
        this.prevElem = null;
    }

    public Element(Object obj) {
        this.obj = obj;
        this.nextElem = null;
        this.prevElem = null;
    }

    public Object getObj() {
        return obj;
    }

    public Element getNextElem() {
        return nextElem;
    }

    public Element getPrevElem() {
        return prevElem;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setNextElem(Element nextElem) {
        this.nextElem = nextElem;
    }

    public void setPrevElem(Element prevElem) {
        this.prevElem = prevElem;
    }
}
