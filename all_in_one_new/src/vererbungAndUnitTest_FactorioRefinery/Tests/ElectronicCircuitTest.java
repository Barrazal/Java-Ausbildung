package vererbungAndUnitTest_FactorioRefinery.Tests;

import vererbungAndUnitTest_FactorioRefinery.Items.CopperCable;
import vererbungAndUnitTest_FactorioRefinery.Items.ElectronicCircuit;
import vererbungAndUnitTest_FactorioRefinery.Items.IronPlate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectronicCircuitTest {
 //   @Test
 //   @DisplayName("is the Item available?")
 //   public void itemAvailable() {
 //       Item<ElectronicCircuitTest> electronicCircuit1 = new Item();
 //       electronicCircuit1.add(IronPlate, 1);
 //       electronicCircuit1.add(CopperCable, 3);
 //       electronicCircuit1.setassemblyMachine(true);
//
 //       assertAll("Item created",
 //               () -> assertEquals("electronicCircuit in Inventory", electronicCircuit1.getAmount()),
 //               () -> assertEquals(true, electronicCircuit1.getAssemblyMachineStatus())
 //       );
 //   }
//
 //   @Test
 //   @DisplayName("Item not available-- No Assembler")
 //   public void itemNotAvailable() {
 //       Item<ElectronicCircuitTest> electronicCircuit2 = new Item();
 //       electronicCircuit2.add(IronPlate, 1);
 //       electronicCircuit2.add(CopperCable, 3);
 //       electronicCircuit2.setassemblyMachine(false);
//
 //       assertAll("electronicCircuit not created",
 //               () -> assertEquals("Enough Items to create electronicCircuit", electronicCircuit2.getAmount()),
 //               () -> assertEquals(false, electronicCircuit2.getAssemblyMachineStatus())
 //       );
 //   }
//
 //   @Test
 //   @DisplayName("Item not available-- Lack items")
 //   public void itemNotAvailable() {
 //       Item<ElectronicCircuitTest> electronicCircuit3 = new Item();
 //       electronicCircuit3.add(IronPlate, 1);
 //       electronicCircuit3.add(CopperCable, 1);
 //       electronicCircuit3.setassemblyMachine(true);
//
 //       assertAll("electronicCircuit not created",
 //               () -> assertEquals("not enough Items for assemblyMachine!", electronicCircuit3.getAmount()),
 //               () -> assertEquals(true, electronicCircuit3.getAssemblyMachineStatus())
 //       );
 //   }
//
   @Test
   @DisplayName("Test Item ist craftable")
   public void TestItemNoMaterial() {
       ElectronicCircuit electronicCircuit4 = new ElectronicCircuit();
       electronicCircuit4.addComponent(new IronPlate());
       electronicCircuit4.addComponent(new CopperCable());
       electronicCircuit4.addComponent(new CopperCable());
       electronicCircuit4.addComponent(new CopperCable());

       assertEquals(true, electronicCircuit4.isCraftable());
    }
    @Test
    @DisplayName("Test Item ist notcraftable")
    public void TestItemNoValidMaterial() {
        ElectronicCircuit electronicCircuit4 = new ElectronicCircuit();
        electronicCircuit4.addComponent(new IronPlate());
        electronicCircuit4.addComponent(new CopperCable());
        electronicCircuit4.addComponent(new CopperCable());

        assertEquals(false, electronicCircuit4.isCraftable());
    }
//
 //   @Test
 //   @DisplayName("Input Material is equal to Tested Material")
 //   public void getInputMaterialTest() {
 //       Item<ElectronicCircuitTest> electronicCircuit5 = new Item();
 //       electronicCircuit5.add(IronPlate, 1);
 //       electronicCircuit5.add(CopperCable, 3);
 //       assertAll(
 //               () -> assertEquals(IronPlate, electronicCircuit5.getItem(0)),
 //               () -> assertEquals(CopperCable, electronicCircuit5.getItem(1))
 //       );
 //   }
}
