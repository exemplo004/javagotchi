<<<<<<< HEAD
Diretor dir = new Diretor();
Io io = new Io();

void main() {
    Scanner sc = new Scanner(System.in);
=======
package com.terminalroot.game;
>>>>>>> 9942508 (Jogabilidade, resistências e console)

import java.util.Scanner;

<<<<<<< HEAD
    while(true) {
        System.out.println("Escolha um nome para o seu Tamago: ");
        entrada = sc.nextLine();
=======
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
>>>>>>> 9942508 (Jogabilidade, resistências e console)

        System.out.print("Escolha um nome para o seu Tamagotchi: ");
        String nomeInput = sc.nextLine();

        Tamagotchi pet = new Tamagotchi(nomeInput);
        Inimigo comidaAtual = new Inimigo(Inimigo.Tipo.SANDUICHE);

        System.out.println("\nO poderosissimo " + comidaAtual.getTipo() + " caiu do espaco bem na sua frente!");

        while (pet.getEstaVivo()) {
            System.out.println("\n=================================");
            System.out.println("PET: " + pet.getNome() + " | PV: " + pet.getPv() + " | Fome: " + pet.getFome() + " | Energia: " + pet.getEnergia());
            System.out.println("COMIDA: " + comidaAtual.getTipo() + " | PV Comida: " + comidaAtual.getPv());
            System.out.println("=================================");
            System.out.println("1 - Mastigar / Atacar a Comida");
            System.out.println("2 - Receber o Ataque da Comida");
            System.out.println("3 - Dormir");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();

            if (op == 1) {
                pet.mastigar(comidaAtual);
                if (comidaAtual.getPv() <= 0) {
                    System.out.println("\n[VITORIA] Voce conseguiu amassar o " + comidaAtual.getTipo() + "!");
                    System.out.println("Um novo prato chamado LASANHA veio ao resgate de seu ex parceiro!");
                    comidaAtual = new Inimigo(Inimigo.Tipo.LASANHA);
                }
            } else if (op == 2) {
                comidaAtual.atacar(pet);
            } else if (op == 3) {
                pet.dormir();
            } else if (op == 4) {
                break;
            }
        }

        System.out.println("Fim de jogo!");
        sc.close();
    }
<<<<<<< HEAD

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

=======
}
>>>>>>> 9942508 (Jogabilidade, resistências e console)
