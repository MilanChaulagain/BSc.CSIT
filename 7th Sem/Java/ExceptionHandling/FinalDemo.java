package ExceptionHandling;

class MyClass {

    // 1️⃣ final variable (constant)
    final int CONSTANT_VALUE = 100;

    // 2️⃣ final method (cannot be overridden)
    public final void showFinalMessage() {
        System.out.println("This is a final method. It cannot be overridden.");
    }

    // 3️⃣ finalize method (called before object is garbage collected)
    @Override
    protected void finalize() {
        System.out.println("Finalize method called before object is destroyed.");
    }
}

// Final class cannot be inherited
final class FinalClass {
    void display() {
        System.out.println("This is a final class.");
    }
}

public class FinalDemo {
    public static void main(String[] args) {

        // Demonstrating final variables
        MyClass obj = new MyClass();
        System.out.println("Final constant value: " + obj.CONSTANT_VALUE);

        // Demonstrating final method
        obj.showFinalMessage();

        // Demonstrating final class usage
        FinalClass fc = new FinalClass();
        fc.display();

        // Demonstrating finally block
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e);
        } finally {
            System.out.println("Finally block always executes.");
        }

        // Demonstrating finalize()
        obj = null; // Remove reference to object
        System.gc(); // Request garbage collection

        System.out.println("End of main method.");
    }
}
