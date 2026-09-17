public class Acoes {
    // TODO completar o combate em turnos
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
        t.felicidade += deltaFelicidade;

        System.out.print(t.nome + "Brincou na lama e se divertiu horrores!\n" +
                "\tFELICIDADE: " + t.felicidade + " (" + deltaFelicidade + ")\n" +
                "\tFOME: " + t.fome + " (" + deltaFome + ")\n" +
                "\tHIGIENE: " + t.higiene + " (" + deltaHigiene + ")");
    }

    public static void Dormir(Tamago t) {
        if (t.fome < 30) {
            System.out.println(t. nome + " está com fome demais para ir dormir... coma alguma coisa!");
        } else {
            System.out.println(t.nome + " foi dormir.\nZZZzzz...");

            // TODO: passar o tempo
            t.energia = 100;
            t.fome = 25;
            t.pv += 30;

            System.out.println("Bom dia flor do dia!\n" + t + "\n");
        }
    }

    // TODO
    public static void Explorar() {
        System.out.println("O usuário escolheu , e aí?");
    }
}
