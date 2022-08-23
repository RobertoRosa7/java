public class FluxoComError {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            method1();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println(e.getClass().getName() + " " + e.getMessage());
        }
        System.out.println("Fim do main");
    }

    private static void method1() {
        System.out.println("Ini do metodo1");
        method2();
        System.out.println("Fim do metodo1");
    }

    /**
     * Execute from zero to five
     * method private void
     * need to execute on stack
     */
    private static void method2() {
        System.out.println("Ini do metodo2");
//        method2();
        System.out.println("Fim do metodo2");
    }
}