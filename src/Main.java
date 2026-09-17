Diretor dir = new Diretor();
Io io = new Io();

void main() {
    Scanner sc = new Scanner(System.in);

    String entrada;

    while(true) {
        System.out.println("Escolha um nome para o seu Tamago: ");
        entrada = sc.nextLine();

        if (entrada.isEmpty()) { System.out.println("Nome invahlido!"); }
        else break;
    }

    Tamago jogador = new Tamago(entrada);

    // Loop do jogo
    while (true) {
        int escolha;

        System.out.println("Escolha o que gostaria de fazer agora:\n" +
                "1. Comer\n" +
                "2. Brincar\n" +
                "3. Dormir\n" +
                "4. Explorar\n" +
                "0. Sair do jogo"
        );
        escolha = io.getIntEntre(0, 4);

        switch (escolha) {
            case 1: Acoes.Comer(dir, io); break;
            case 2: Acoes.Brincar(jogador); break;
            case 3: Acoes.Dormir(jogador); break;
            case 4: Acoes.Explorar(); break;
            default:
                System.out.println("hmmm, como eu cheguei aqui?");
            case 0: System.exit(0);
        }
    }
}

