package oop1AndOop2_exercises.wrongTry_double_chain_list_with_other;
public class Object {
    String obj;
    Object nextElem, prevElem;

    public Object(){
        this.obj = null;
        this.nextElem = null;
        this.prevElem = null;
    }

    public Object(String obj) {
        this.obj = obj;
        this.nextElem = null;
        this.prevElem = null;
    }

    public String getObj() {
        return obj;
    }

    public Object getNextElem() {
        return nextElem;
    }

    public Object getPrevElem() {
        return prevElem;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public void setNextElem(Object nextElem) {
        this.nextElem = nextElem;
    }

    public void setPrevElem(Object prevElem) {
        this.prevElem = prevElem;
    }
}
