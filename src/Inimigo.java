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
        SANDUICHE (3.0, 30, 0.5, 0.2, 0.0),
        LASANHA   (3.0, 80, 0.3, 0.1, 0.0),
        BOLO      (2.0, 50, 0.2, 0.0, 0.2),
        SALADA    (4.0, 20, 0.0, 0.0, 0.0);

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
}
