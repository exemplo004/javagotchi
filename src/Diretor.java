import java.util.Random;

// O diretor é reponsável por "fazer o jogo acontecer"
// Ele decidirá algumas coisas como quando o jogo acaba, quais inimigos/itens entregar, essas coisas
public class Diretor {
    Random rand = new Random();

    // Retorna um novo inimigo cujo tipo é gerado aleatoriamente
    // Utiliza o enum Inimigo.Tipo para fazer suas contas
    public Inimigo gerarInimigo() {
        int qtInimigos = Inimigo.Tipo.values().length;
        int r = rand.nextInt(qtInimigos);

        return new Inimigo(Inimigo.Tipo.values()[r]);
    }

    public double CalcularFuga(Inimigo ini) {
        // Desvantagem fica maior a depender dos PV do inimigo, dificultando a fuga
        double desvantagem = 1 - ( ini.pv / 80 ) / 2;
        double r = rand.nextDouble();
        double final = r * desvantagem();
        System.out.printf("%lf (r) * %lf (desv) = %lf\n", r, desvantagem, );// DONKEY

    }
}
