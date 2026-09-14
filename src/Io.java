import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Classe que deverá conter métodos voltados para a interação do jogador com o jogo.
public class Io {
    Scanner sc = new Scanner(System.in);

    // Força o usuário a inserir um número entre <maior> e <menor>
    public int getIntEntre(int menor, int maior) {
        int escolha;

        while (true) {
            // Previne o usuário de inserir um valor que não seja numérico
            while (!sc.hasNextInt()) {
                System.out.println("A entrada deve ser numehrica!");
                sc.next();
            }

            escolha = sc.nextInt();

            if (escolha < menor || escolha > maior) System.out.println("Escolha uma das alternativas disponihveis");
            else break;
        }
        return escolha;
    }

    // Espera o usuário apertar enter para dar continuidade ao jogo
    public static void esperarEnter() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nPressione Enter para continuar.");
        try {
            r.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
