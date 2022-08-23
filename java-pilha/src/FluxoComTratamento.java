public class FluxoComTratamento {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            method1();
        } catch (ArithmeticException | NullPointerException | MinhaException exception) {
            System.out.println(exception.getClass().getName() + " " + exception.getMessage());
        }
        System.out.println("Fim do main");
    }

    private static void method1() throws MinhaException {
        System.out.println("Ini do method1");
        method2();
        System.out.println("Fim do method1");
    }

    /**
     * Execute from zero to five
     * method private void
     * need to execute on stack
     * @since 1.0
     * @author Roberto
     */
    private static void method2() throws MinhaException {
        System.out.println("Ini do method2");

        throw new MinhaException("New exception thrown");

//        System.out.println("Fim do method2");
    }
}