public class Tamago {
    private double pv;
    private double fome;
    private double saude; // Tomar banho pra evitar doencas(?)
    private final String nome;

    public Tamago(String nome) {
        this.nome = nome;
        this.pv = 100;
        this.fome = 0;
    }

    public void Explorar() {
        // Explorar gasta tempo e saúde, mas tem chance de encontrar um talher ou remédio
    }

    @Override
    public String toString() {
        // Seria interessante ocultar algumas informações do jogador. Ao invés de dizer o quanto ele tem de fome, dizer
        // 'está com muita fome' ou 'está saciado' dependendo do nível da fome ~Kristhian
        return nome + " tem " + pv + " pontos de vida, e estah com " + fome + " de fome.";
    }
}
