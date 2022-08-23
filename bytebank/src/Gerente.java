public class Gerente extends Funcionario {
    private final int senha = 1234;

    public double getBonificacao() {
        return super.getBonificacao() + super.getSalario();
    }

    public boolean autentica(int senha) {
        return this.senha == senha;
    }
}
