import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Class variables
        Stack<Integer> theStack = new Stack<>();
        Queue<Integer> theQueue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int count = 0; //Use this to get the length of the array.

        //Get the array length from the user
        while (count <= 0) {
            IO.print("\nHow many values would you like to enter?: ");
            try {
                count = scan.nextInt();

                if  (count <= 0) {
                    System.out.println("Number must be greater than 0: ");
                }

            } catch (Exception e) {
                IO.println("You must enter a valid integer.");
                scan.nextLine(); //Consumes the user input even though we don't use it.
            }
        }

        IO.println();

        //Declare the array
        int[] theArray = new int[count];

        for  (int i = 0; i < count; i++) {
            int number;
            IO.print("Enter a number: ");
            try {
                number = scan.nextInt();
                theArray[i] = number;
                theStack.push(number);
                theQueue.add(number);

            } catch (Exception e) {
                IO.println("You must enter a valid integer.");
                scan.nextLine();
            }
        }

        //Display the original collections
        IO.print("\nOriginal Collections: ");

        IO.print("\n\nThe Array: ");
        printArray(theArray);
        IO.println();
        IO.print("The stack: ");
        printStack(theStack);
        IO.println();
        IO.print("The Queue : ");
        printQueue(theQueue);

        IO.println("\n\nReversed collections: ");

        //Reverse methods to print collections
        reverseArray(theArray);
        theStack = reverseStack(theStack);
        reverseQueue(theQueue);

        IO.print("\nArray: ");
        printArray(theArray);
        IO.println();
        IO.print("The Stack: ");
        printStack(theStack);
        IO.println();
        IO.print("The Queue : ");
        printQueue(theQueue);
        IO.println();

    }

    //Helper methods to print collections
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            IO.print(array[i] + " ");
        }
    }

    public static void printStack(Stack<Integer> stack){
        for (int i = 0; i < stack.size(); i++) {
            IO.print(stack.elementAt(i) + " ");
        }
    }

    public static void printQueue(Queue<Integer> queue){
        for (int number : queue) {
            IO.print(number + " ");
        }
    }

    //Helper methods to revers collections
    public static void reverseArray(int[] array){
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            //Increment inwards
            left++;
            right--;
        }
    }

    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        Stack<Integer> reversed = new Stack<>();
        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }
        return reversed;
    }

    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> temp = new Stack<>();

        //Empty the Queue into the Stack
        while (!queue.isEmpty()) {
            temp.push(queue.poll());
        }

        //Empty the Stack back into the Queue
        while (!temp.isEmpty()) {
            queue.add(temp.pop());
        }
    }
}
