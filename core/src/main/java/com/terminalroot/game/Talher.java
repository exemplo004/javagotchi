package com.terminalroot.game;

public class Talher {
    public enum Tipo { COLHER, GARFO, FACA }
    public enum Material { MADEIRA, FERRO, PRATA }

    private double danoImpactante;
    private double danoPerfurante;
    private double danoCortante;
    private final Tipo tipo;
    private final Material material;

    public Talher(Tipo tipo, Material material) {
        this.tipo = tipo;
        this.material = material;

        danoCortante = 5;
        danoPerfurante = 5;
        danoImpactante = 5;

        switch (tipo) {
            case COLHER:
                danoImpactante *= 2;
                break;
            case FACA:
                danoCortante *= 2;
                break;
            case GARFO:
                danoPerfurante *= 2;
                break;
        }

        double mult;

        switch (material) {
            case MADEIRA:
                mult = 1.0;
                break;
            case FERRO:
                mult = 1.2;
                break;
            case PRATA:
                mult = 1.5;
                break;
            default:
                throw new IllegalStateException("Erro");
        }

        danoImpactante *= mult;
        danoPerfurante *= mult;
        danoCortante *= mult;
    }

    public double getDanoTotal() {
        return danoImpactante + danoPerfurante + danoCortante;
    }

    public double getDanoImpactante() { return danoImpactante; }
    public double getDanoPerfurante() { return danoPerfurante; }
    public double getDanoCortante() { return danoCortante; }

    @Override
    public String toString() {
        return tipo + " de " + material;
    }
}