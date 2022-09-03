public class Bonificacao {
    private double soma;

    public void registra(Gerente gerente) {
        double boni = gerente.getBonificacao();
        this.setSoma(this.soma + boni);
    }

    public void setSoma(double soma) {
        this.soma = soma;
    }
}
