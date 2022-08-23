public class ByteBankApplication {

    public static void main(String[] args) {
        createFuncionario();
        createGerente();
    }

    public static void createFuncionario() {
        Funcionario nico = new Funcionario();
        nico.setNome("Nico");
        nico.setSalario(200.0);
        nico.setCpf("3621291869");

        System.out.printf("%s <= Funcionário%n", nico.getNome());
        System.out.printf("%f <= Funcionário salário + bonficação%n", nico.getBonificacao());
    }

    public static void createGerente() {
        Gerente gerente = new Gerente();
        gerente.setNome("John");
        gerente.setSalario(100.0);

        Bonificacao boni = new Bonificacao();
        boni.registra(gerente);
        boolean auth = gerente.autentica(1234);


        System.out.printf("%s <= Gerente%n", gerente.getNome());
        System.out.printf("%f <= Gerente salário + bonificação%n", gerente.getBonificacao());
        System.out.printf("%s <= Gerente autenticado%n", (auth ? "Sim" : "Não"));
    }
}
