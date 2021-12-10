package vererbungAndUnitTest_FactorioRefinery.Items;

import vererbungAndUnitTest_FactorioRefinery.Item;

import java.util.ArrayList;
import java.util.List;


public class ElectronicCircuit extends Item {
    private final Integer requiredItems = 2;
    private final Integer requiredLength = 4;

    public ElectronicCircuit() {
    }


    @Override
    public void addComponent(Item components) {
        super.components.add(components);
    }

    @Override
    public boolean isCraftable() {

        if (!super.components.isEmpty()) {
            List<Item> needed = new ArrayList<>();
            needed.add(new IronPlate());
            needed.add(new CopperCable());
            needed.add(new CopperCable());
            needed.add(new CopperCable());

            Integer actualLength = 0;

            for (int i = 0; i < super.components.size() && i < needed.size(); i++) {
                if (super.components.get(i).getClass().equals(needed.get(i).getClass())) {
                    actualLength++;
                }
            }
            if (actualLength == requiredLength) {
                return true;
            }
        }
        return false;
    }


}
