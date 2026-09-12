import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Classe que deverá conter métodos voltados para a interação do jogador com o jogo.
public class io {
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
