public class Talher {
    public enum Tipo { COLHER, GARFO, FACA }
    public enum Material { MADEIRA, FERRO, PRATA }

    private float danoImpactante;
    private float danoPerfurante;
    private float danoCortante;
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
            case MADEIRA -> 1;
            case FERRO -> 1.2;
            case PRATA -> 1.5;
        };

        danoImpactante *= mult;
        danoPerfurante *= mult;
        danoCortante *= mult;
    }

    @Override
    public String toString() {
        return "Um(a) " + tipo + " de " + material + "." +
                "\nImpactante: " + danoImpactante +
                "\nPerfurante: " + danoPerfurante +
                "\nCortante: " + danoCortante;
    }
}