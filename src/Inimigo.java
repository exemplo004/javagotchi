public class Inimigo {
    Tipo tipo;
    public double pv;
    public final double danoBase;

    public final double amortecimento;      // Impacto
    public final double densidadeBalistica; // Perfuração
    public final double coesaoMolecular;    // Corte

    public Inimigo(Tipo tipo) {
        pv = tipo.pv;
        danoBase = tipo.danoBase;

        amortecimento = tipo.amortecimento;
        densidadeBalistica = tipo.densidadeBalistica;
        coesaoMolecular = tipo.coesaoMolecular;

        this.tipo = tipo;
    }

    public enum Tipo {
        SANDUICHE (30, 3.0, 0.5, 0.2, 0.0),
        LASANHA   (80, 3.0, 0.3, 0.1, 0.0),
        BOLO      (50, 2.0, 0.2, 0.0, 0.2),
        SALADA    (20, 4.0, 0.0, 0.0, 0.0),
        MACARRAO  (70, 5.0, 0.9, 0.0, 0.6);

        public final double pv;
        public final double danoBase;

        // Resistências (é zoeira viu?)
        public final double amortecimento;      // Impacto
        public final double densidadeBalistica; // Perfuração
        public final double coesaoMolecular;    // Corte

        Tipo(double pv, double danoBase, double amortecimento, double densidadeBalistica, double coesaoMolecular) {
            this.danoBase = danoBase;
            this.pv = pv;
            this.amortecimento = amortecimento;
            this.densidadeBalistica = densidadeBalistica;
            this.coesaoMolecular = coesaoMolecular;
        }
    }

    public void Atacar(Tamago jogador) {
        System.out.printf("%s ataca %s e causa %d de dano.\n", this.tipo, jogador.nome, danoBase);
        jogador.pv -= this.danoBase;
    }

    @Override
    public String toString() {
        return "Eu sou um(a) " + this.tipo.name() + " do mal!";
    }
}
