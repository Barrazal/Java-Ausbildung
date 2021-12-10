package vererbungAndUnitTest_FactorioRefinery;


import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    String type;
    Integer amount;
    Boolean assembler;
    //   Boolean smeltery;
    protected List<Item> components = new ArrayList<>();


    public abstract void addComponent(Item components);


    public abstract boolean isCraftable();

    // public String getType() {
    //     return type;
    // }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getAssembler() {
        return assembler;
    }

    public void setAssembler(Boolean assembler) {
        this.assembler = assembler;
    }


}
