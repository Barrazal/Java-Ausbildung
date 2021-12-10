//package FactorioRefinery.Tests;
//
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class RefineryTest {
//    Item<electronicCircuit> electronicCircuitTest = new Item();
//    Item<ironGearWheel> ironGearWheelTest = new Item();
//    Item<pipe> pipeTest = new Item();
//    Item<steelPlate> steelPlateTest = new Item();
//    Item<stoneBrick> stoneBrickTest = new Item();
//
//    electronicCircuitTest.setAmount(electronicCircuit,10);
//        ironGearWheelTest.setAmount(ironGearWheel,10);
//        pipeTest.setAmount(pipe,10);
//        steelPlateTest.setAmount(steelPlate,10);
//
//
//    @Test
//    @DisplayName("Can a refinery be built?")
//    public void createRefineryTest() {
//        stoneBrickTest.setAmount(stoneBrick, 10);
//
//        Object<Refinery> newRefineryTest1 = new Object(electronicCircuitTest, ironGearWheelTest, pipeTest, steelPlateTest, stoneBrickTest);
//        newRefineryTest1.setassemblyMachine(true);
//
//        assertEquals("Refinery Created", newRefineryTest1.createRefinery());
//    }
//
//    @Test
//    @DisplayName("Refinery, cause of Lack of item, not created")
//    public void createRefineryTest_negative() {
//
//        stoneBrickTest.setAmount(stoneBrick, 5);
//
//        Object<Refinery> newRefineryTest2 = new Object(electronicCircuitTest, ironGearWheelTest, pipeTest, steelPlateTest, stoneBrickTest);
//        newRefineryTest2.setassemblyMachine(true);
//
//        assertEquals("Refinery not Created", newRefineryTest2.createRefinery());
//    }
//
//    @Test
//    @DisplayName("Refinery not created, No Assembly Machine")
//    public void createRefineryTest_negative() {
//
//        stoneBrickTest.setAmount(stoneBrick, 10);
//
//        Object<Refinery> newRefineryTest2 = new Object(electronicCircuitTest, ironGearWheelTest, pipeTest, steelPlateTest, stoneBrickTest);
//        newRefineryTest2.setassemblyMachine(false);
//
//        assertEquals("Refinery not Created", newRefineryTest2.createRefinery());
//    }
//
//  //  @Test
//  //  @DisplayName("Is the Refinery in Inventory")
//  //  public void RefineryInInventoryTest() {
////
//  //      stoneBrickTest.setAmount(stoneBrick, 10);
////
//  //      Object<Refinery> newRefineryTest3 = new Object(electronicCircuitTest, ironGearWheelTest, pipeTest, steelPlateTest, stoneBrickTest);
//  //      newRefineryTest1.setassemblyMachine(true);
////
//  //      assertEquals(true, newRefineryTest3.getInventoryStatus());
//  //  }
//
//
//}
