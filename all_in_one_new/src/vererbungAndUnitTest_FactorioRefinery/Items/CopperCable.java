package vererbungAndUnitTest_FactorioRefinery.Items;

import vererbungAndUnitTest_FactorioRefinery.Item;

public class CopperCable extends Item {
    Integer amount;

    public CopperCable() {
    }

    public CopperCable(Item components) {
        super.components.add(components);
    }

    @Override
    public void addComponent(Item components) {
        super.components.add(components);
    }

    @Override
    public boolean isCraftable() {
        return false;
    }
}
