package InnerClass;

class A {
    class B {
        public void test() {
            int i = 0;
            while (i <= 100) {
                System.out.println(i);
                i = i + 2; 
            }
        }
    }
    public static void main(String[] args) {
        A objA = new A();
        B objB = objA.new B();

        objB.test();
    }
}

