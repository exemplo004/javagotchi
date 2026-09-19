package com.terminalroot.game;

public class Inimigo {
    private Tipo tipo;
    private double pv;
    private double danoBase;

    private double amortecimento;       // Resistência a Impacto
    private double resPerf;             // Resistência a Perfuração
    private double resCort;             // Resistência a Corte

    public enum Tipo {
        SANDUICHE (30.0, 10.0, 0.5, 0.2, 0.0),
        LASANHA   (80.0, 20.0, 0.3, 0.1, 0.0),
        BOLO      (50.0, 15.0, 0.2, 0.0, 0.2),
        SALADA    (20.0, 5.0, 0.0, 0.0, 0.0);

        public final double pv;
        public final double danoBase;
        public final double amortecimento;
        public final double resPerf;
        public final double resCort;

        Tipo(double pv, double danoBase, double amortecimento, double resPerf, double resCort) {
            this.pv = pv;
            this.danoBase = danoBase;
            this.amortecimento = amortecimento;
            this.resPerf = resPerf;
            this.resCort = resCort;
        }
    }

    public Inimigo(Tipo tipo) {
        this.tipo = tipo;
        this.pv = tipo.pv;
        this.danoBase = tipo.danoBase;
        this.amortecimento = tipo.amortecimento;
        this.resPerf = tipo.resPerf;
        this.resCort = tipo.resCort;
    }

    // Método para o prato bater ou dar indigestão no pet
    public void atacar(Tamagotchi jogador) {
        System.out.printf("%s atacou %s e causou %.1f de dano!\n", this.tipo, jogador.getNome(), danoBase);
        jogador.receberDano(danoBase);
    }

    // Calculo para o quanto de dano a comida recebe baseada nas resistências dela contra o talher esquipado
    public double calcDanoRecebido(Talher talher) {
        double dImpacto = Math.max(0, talher.getDanoImpactante() - (talher.getDanoImpactante() * amortecimento));
        double dPerf = Math.max(0, talher.getDanoPerfurante() - (talher.getDanoPerfurante() * resPerf));
        double dCorte = Math.max(0, talher.getDanoCortante() - (talher.getDanoCortante() * resCort));
        return dImpacto + dPerf + dCorte;
    }

    public void receberDano(double dano) {
        this.pv -= dano;
        if (this.pv < 0) this.pv = 0;
    }

    public double getPv() { return pv; }
    public double getDanoBase() { return danoBase; }
    public Tipo getTipo() { return tipo; }
}
