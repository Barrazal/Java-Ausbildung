package vererbungAndUnitTest_FactorioRefinery.Items;

import vererbungAndUnitTest_FactorioRefinery.Item;

public class IronPlate extends Item {
    Integer amount;

    public IronPlate() {
    }

    public IronPlate(Item components) {
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
