public class Acoes {
    // TODO completar o combate em turnos
    public static void Comer(Tamago j, Diretor dir, Io io) {
        Inimigo opo = dir.gerarInimigo();
        System.out.println(opo);

        while (true) {
            int escolha;
            System.out.println("A wild " + opo.tipo + " appears!\n" +
                    "O que você fará?\n " +
                    "1. Atacar\n" +
                    "2. Usar um item\n" +
                    "3. Alterar equipamento\n" +
                    "4. Tentar fugir\n" +
                    "0. Sair do jogo"
            );
            escolha = io.getIntEntre(0, 4);

            switch (escolha) {
                case 1: Acoes.Atacar(j, opo); break;
                case 2: j.UsarItem(j); break;
                case 3: j.AlterarEquipamento(); break;
                case 4: Acoes.TentarFugir(dir); break;
                case 0: System.exit(0);
                default: System.out.println("hmmm, como eu cheguei aqui?");
            }
        }
    }

    // TODO
    private static void TentarFugir(Diretor dir, Inimigo ini) {
        double consegueFugir  = dir.CalcularFuga(ini);
    }

    // TODO
    private static void Atacar(Tamago j, Inimigo opo) {

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
