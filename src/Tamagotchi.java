package com.terminalroot.game;

public class Tamagotchi {
    private String nome;
    private double pv;
    private int fome;
    private int energia;
    private int felicidade;
    private boolean estaVivo;
    private Talher talherEquipado;

    public Tamagotchi(String nome) {
        this.nome = nome;
        this.pv = 100.0;
        this.fome = 50;
        this.energia = 100;
        this.felicidade = 80;
        this.estaVivo = true;

        // Equipa um talher pra atacar por que sim ou nada a ver?
        this.talherEquipado = new Talher(Talher.Tipo.COLHER, Talher.Material.MADEIRA);
    }

    // Método para o tamago poder atacar/mastigar a comida usando o talher que ele equipou
    public void mastigar(Inimigo comida) {
        if (!estaVivo) return;

        double danoCalculado = comida.calcDanoRecebido(talherEquipado);
        comida.receberDano(danoCalculado);

        // Mastigar vai reduzir a fome do pet e vai gastar um pouco de energia
        this.fome -= 10;
        if (this.fome < 0) this.fome = 0;
        
        this.energia -= 5;
        if (this.energia < 0) this.energia = 0;

        System.out.printf("%s usou %s e causou %.1f de dano no %s!\n", nome, talherEquipado, danoCalculado, comida.getTipo());

        verificarSobrevivencia();
    }

    public void dormir() {
        if (!estaVivo) return;
        this.energia = 100;
        this.fome += 15;
        System.out.println(nome + " dormiu e recuperou suas energias!");
        verificarSobrevivencia();
    }

    public void brincar() {
        if (!estaVivo) return;
        this.felicidade += 20;
        if (this.felicidade > 100) this.felicidade = 100;
        this.energia -= 10;
        this.fome += 10;
        System.out.println(nome + " brincou e se divertiu!");
        verificarSobrevivencia();
    }

    public void receberDano(double dano) {
        this.pv -= dano;
        if (this.pv <= 0) {
            this.pv = 0;
            this.estaVivo = false;
        }
    }

    private void verificarSobrevivencia() {
        if (this.fome >= 100 || this.energia <= 0 || this.pv <= 0) {
            this.estaVivo = false;
            System.out.println("\n[!] " + nome + " não resistiu e desmaiou/morreu!");
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public double getPv() { return pv; }
    public int getFome() { return fome; }
    public int getEnergia() { return energia; }
    public int getFelicidade() { return felicidade; }
    public boolean getEstaVivo() { return estaVivo; }
    public Talher getTalherEquipado() { return talherEquipado; }
    public void setTalherEquipado(Talher novoTalher) { this.talherEquipado = novoTalher; }
}