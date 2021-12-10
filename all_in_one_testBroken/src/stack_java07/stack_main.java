package stack_java07;

public class stack_main {
    public static void main(String[] args) throws StackTooSmallException {
        intStack_outdated stack1 = new intStack_outdated();

        stack1.push(1, "stack_push1", "stack-585-wet-588", true);
        stack1.push(2, "stack_push2", "stack-585-wet-588", true);
        stack1.push(3, "stack_push3", "stack-585-wet-588", true);
        stack1.push(4, "stack_push4", "stack-585-wet-588", true);
        stack1.push(5, "stack_push5", "stack-585-wet-588", false);
        stack1.push(6, "stack_push6", "stack-585-wet-588", true);
        stack1.push(7, "stack_push7", "stack-585-wet-588", true);
        stack1.push(8, "stack_push8", "stack-585-wet-588", true);
        stack1.push(9, "stack_push9", "stack-585-wet-588", true);
        stack1.push(11, "stack_push10", "stack-585-wet-588", false);
        stack1.push(12, "stack_push10", "stack-585-wet-588", false);
        stack1.push(13, "stack_push10", "stack-585-wet-588", false);
        stack1.push(14, "stack_push10", "stack-585-wet-588", false);
        System.out.println();
        stack1.peek();
        System.out.println();
        stack1.pop();
        stack1.pop();
        stack1.pop();
        System.out.println();
        stack1.size();
        System.out.println();
        stack1.peek();
        System.out.println();

        stack1.pop(3);
        System.out.println();
        stack1.peek();
        System.out.println();
        stack1.size();





    }

}
