public abstract class Talher {
    public enum Tipo { COLHER, GARFO, FACA }
    public enum Material { MADEIRA, FERRO, PRATA }

    float danoImpactante;
    float danoPerfurante;
    float danoCortante;
    String tipo;     // Colher, garfo, ou faca
    Material material;

    public Talher(Tipo tipo, Material material) {
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
}