public class Inimigo {
    public enum Tipo {
        SANDUICHE (0.5, 0.2, 0.0),
        LASANHA   (0.3, 0.1, 0.0),
        BOLO      (0.2, 0.0, 0.2),
        SALADA    (0.0, 0.0, 0.0);

        // Resistências (é zoeira viu?)
        public final double amortecimento;      // Impacto
        public final double densidadeBalistica; // Perfuração
        public final double coesaoMolecular;    // Corte

        Tipo(double amortecimento, double densidadeBalistica, double coesaoMolecular) {
            this.amortecimento = amortecimento;
            this.densidadeBalistica = densidadeBalistica;
            this.coesaoMolecular = coesaoMolecular;
        }
    }
}
