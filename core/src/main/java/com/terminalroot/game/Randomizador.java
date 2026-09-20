package com.terminalroot.game;

import java.util.Random;

public class Randomizador {
    static Random r = new Random();

    public static Inimigo gerarNovoInimigo() {
        int qtInimigos = Inimigo.Tipo.values().length;
        int n = r.nextInt(qtInimigos);

        return new Inimigo(Inimigo.Tipo.values()[n]);
    }

    public static boolean chance(int i) {
        double d = r.nextDouble();
        double chance = (double) i / 100;

        if (d <= chance) { return true; }
        return false;
    }

    public static void trocarTalher(Tamagotchi pet) {
        int qtTipo = r.nextInt(Talher.Tipo.values().length);
        int qtMat = r.nextInt(Talher.Material.values().length);

        pet.setTalherEquipado(new Talher(Talher.Tipo.values()[qtTipo],
                                         Talher.Material.values()[qtMat]));
    }
}