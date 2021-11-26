public class Element {
    String obj;
    Element nextElem, prevElem;

    public Element(){
        this.obj = null;
        this.nextElem = null;
        this.prevElem = null;
    }

    public Element(String obj) {
        this.obj = obj;
        this.nextElem = null;
        this.prevElem = null;
    }

    public String getObj() {
        return obj;
    }

    public Element getNextElem() {
        return nextElem;
    }

    public Element getPrevElem() {
        return prevElem;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public void setNextElem(Element nextElem) {
        this.nextElem = nextElem;
    }

    public void setPrevElem(Element prevElem) {
        this.prevElem = prevElem;
    }
}
