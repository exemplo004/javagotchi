public class Tamago {
    public final String nome;
    public double pv;
    public double energia;
    public double fome;
    public double higiene; // Tomar banho pra evitar doencas(?)
    public double felicidade;

    public Tamago(String nome) {
        this.nome = nome;
        this.pv = 100;
        this.energia = 100;
        this.fome = 0;
        this.higiene = 100;
        this.felicidade = 100;
    }

    public void Explorar() {
        // Explorar gasta tempo e saúde, mas tem chance de encontrar um talher ou remédio
    }

    @Override
    public String toString() {
        // Seria interessante ocultar algumas informações do jogador. Ao invés de dizer o quanto ele tem de fome, dizer
        // 'está com muita fome' ou 'está saciado' dependendo do nível da fome ~Kristhian
        return "---- " + this.nome.toUpperCase() + " ----" +
                "PV:         " + this.pv + this.pv +
                "Energia:    " + this.energia +
                "Fome:       " + this.fome +
                "Higiene:    " + this.higiene +
                "Felicidade: " + this.felicidade;
    }

    public void UsarItem(Tamago j) {
    }

    public void AlterarEquipamento() {
    }
}
