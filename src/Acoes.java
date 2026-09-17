public class Acoes {
    // TODO
    public static void Comer(Diretor dir, Io io) {
        Inimigo vilao = dir.gerarInimigo();
        System.out.println(vilao);
        io.esperarEnter();
    }

    public static void Brincar(Tamago t) {
        int deltaFome = -30;
        int deltaHigiene = -50;
        int deltaFelicidade = 80;

        // TODO: passar o tempo
        t.fome += deltaFome;
        t.higiene += deltaHigiene;

        System.out.print(t.nome + "Brincou na lama e se divertiu horrores!\n" +
                "\tFELICIDADE: " + t.felicidade + " (" + deltaFelicidade + ")\n" +
                "\tFOME: " + t.fome + " (" + deltaFome + ")\n" +
                "\tHIGIENE: " + t.higiene + " (" + deltaHigiene + ")");
    }

    // TODO
    public static void Dormir() {
        System.out.println("O usuário escolheu , e aí?");
    }

    // TODO
    public static void Explorar() {
        System.out.println("O usuário escolheu , e aí?");
    }
}
