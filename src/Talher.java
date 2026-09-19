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
            case COLHER -> danoImpactante *= 2;
            case FACA -> danoCortante *= 2;
            case GARFO -> danoPerfurante *= 2;
        }

        double mult = switch (material) {
            case MADEIRA -> 1.0;
            case FERRO -> 1.2;
            case PRATA -> 1.5;
        };

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