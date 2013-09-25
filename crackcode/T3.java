public class T3 {

    // 3.1
    static int stackSize = 300;
    static int [] buffer = new int[stackSize * 3];
    static int [] stackPointer = {0, 0, 0};

    public static void push(int stackNum, int value) {
        int index = stackNum * stackSize + stackPointer[stackNum] + 1;
        stackPointer[stackNum]++;
        buffer[index] = value;
    }
    public static int pop(int stackNum) {
        int index = stackNum * stackSize + stackPointer[stackNum];
        stackPointer[stackNum]--;
        int value = buffer[index];
        buffer[index] = 0;
        return value;
    }

    public static int peek(int stackNum) {
        int index = stackNum * stackSize + stackPointer[stackNum];
        return buffer[index];
    }
    public static boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == stackNum * stackSize;
    }

    // 3.1_2
    public static class StackNode {
        public int previous;
        public int value;
        public StackNode(int p, int v){
            value = v;
            previous = p;
        }
    }
    static  int stackSize2 = 300;
    static  int indexUsed = 0;
    static  int[] stackPointer2 = {-1, -1, -1};
    static StackNode[] buffer2 = new StackNode[stackSize2 * 3];

    public static void push2(int stackNum, int value) {
        int lastIndex = stackPointer2[stackNum];
        stackPointer2[stackNum] = indexUsed;
        indexUsed++;
        buffer2[stackPointer2[stackNum]] = new StackNode(lastIndex, value);
    }

    public static int pop2(int stackNum) {
        int value = buffer2[stackPointer2[stackNum]].value;
        int lastIndex = stackPointer2[stackNum];
        stackPointer2[stackNum] = buffer2[stackPointer2[stackNum]].previous;
        buffer2[lastIndex] = null;
        indexUsed--;
        return value;
    }

    public static int peek2(int stackNum) {
        return buffer2[stackPointer2[stackNum]].value;
    }
    public static boolean isEmpty2(int stackNum) {
        return stackPointer2[stackNum] == -1;
    }

    // 3.2

    public static void main(String[] args) {
        System.out.println("\n===3.1===\n");
        push(2, 4);
        System.out.println(peek(2));
        push(0, 3);
        push(0, 7);
        push(0, 5);
        System.out.println(peek(0));
        pop(0);
        System.out.println(peek(0));
        pop(0);
        System.out.println(peek(0));
        System.out.println("");

        System.out.println("\n===3.1_2===\n");
        push2(2, 4);
        System.out.println(peek(2));
        push2(0, 3);
        push2(0, 7);
        push2(0, 5);
        System.out.println(peek2(0));
        pop2(0);
        System.out.println(peek2(0));
        pop2(0);
        System.out.println(peek2(0));
        System.out.println("");

        System.out.print("\n===3.2===\n");
        
    }
}