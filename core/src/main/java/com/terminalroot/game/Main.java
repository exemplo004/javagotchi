package com.terminalroot.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont fonte;

    // Texturas Usadas
    private Texture fundo;
    private Texture mimiSprite;
    private Texture comer;
    private Texture defender;
    private Texture dormir;
    private Texture sair;

    // Sprites usados para tentar fazer as animacoes das acoes
    private Texture comer1;
    private Texture comer2;
    private Texture defender1;
    private Texture defender2;
    private Texture dormir1;
    private Texture dormir2;

    //teste para a textura atual
    private Texture spriteAtual;
    private Texture spriteAcao1;
    private Texture spriteAcao2;
    private float tempoAnimacao = 0f;

    private final float INTERVALO_ANIMACAO = 0.3f;

    // Logica para poder ser usado no Jogo
    private Tamagotchi pet;
    private Inimigo comidaAtual;
    private String mensagemStatus = "";

    // Movimento do Tamagotchi
    private float posX = 0f;
    private float posY = 130f;
    private float velocidade = 150f;
    private boolean andandoParaDireita = true;

    //  Valores fixos usados para o tamanho e as posicoes
    private final float LARGURA_MIMI = 64f;
    private final float ALTURA_MIMI = 64f;

    private final float LARGURA_BOTAO = 80f;
    private final float ALTURA_BOTAO = 75f;

    private final float BOTAO_Y = 30f;
    private final float BOTAO_COMER_X = 130f;
    private final float BOTAO_DEFENDER_X = 230f;
    private final float BOTAO_DORMIR_X = 330f;
    private final float BOTAO_SAIR_X = 430f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        // Fonte usada para a caixa de texto no jogo
        fonte = new BitmapFont();
        fonte.setColor(Color.WHITE);
        fonte.getData().setScale(1.2f);

        // Carregando a textura das imagens para serem usadas
        fundo = new Texture("libgdx.png");
        mimiSprite = new Texture("mimichi.png");
        comer = new Texture("comer.png");
        defender = new Texture("defender.png");
        dormir = new Texture("dormir.png");
        sair = new Texture("sair.png");

        // Carregando os sprites das animacoes
        comer1 = new Texture("comer1.png");
        comer2 = new Texture("comer2.png");
        defender1 = new Texture("defender1.png");
        defender2 = new Texture("defender2.png");
        dormir1 = new Texture("dormir1.png");
        dormir2 = new Texture("dormir2.png");

        // Instanciando o Tamagotchi e o primeiro Inimigo
        pet = new Tamagotchi("Mimichi");
        comidaAtual = new Inimigo(Inimigo.Tipo.SANDUICHE);

        //teste
        spriteAtual = mimiSprite;

        //printo a primeira mensagem para dar inicio ao jogo
        mensagemStatus = "O " + comidaAtual.getTipo() + " caiu do espaco bem na sua frente!";
    }

    @Override
    public void render() {

        // O metodo para poder usar o mouse para clicar nos botoes
        processarEntradas();

        // Movimentacao usada para o tamagotchi andar para direita e esquerda
        float deltaTime = Gdx.graphics.getDeltaTime();

        // Alterna imagem do mimichi para os dois sprites da acao atual
        if (spriteAcao1 != null && spriteAcao2 != null) {
            tempoAnimacao += deltaTime;

            if (tempoAnimacao >= INTERVALO_ANIMACAO) {
                tempoAnimacao = 0f;

                if (spriteAtual == spriteAcao1) {
                    spriteAtual = spriteAcao2;
                } else {
                    spriteAtual = spriteAcao1;
                }
            }
        }

        if (andandoParaDireita) {
            posX += velocidade * deltaTime;
            if (posX + LARGURA_MIMI >= Gdx.graphics.getWidth()) {
                andandoParaDireita = false;
            }
        } else {
            posX -= velocidade * deltaTime;
            if (posX <= 0) {
                andandoParaDireita = true;
            }
        }

        // Apenas para poder limpar a tela
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // usado pelo libgdx para desenhar as imagens como o fundo, Tamagotchi e botões em geral
        batch.begin();

        // Tela de fundo
        batch.draw(fundo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Tamagotchi
        batch.draw(
            spriteAtual,
            posX,
            posY,
            LARGURA_MIMI,
            ALTURA_MIMI,
            0,
            0,
            spriteAtual.getWidth(),
            spriteAtual.getHeight(),
            !andandoParaDireita,
            false
        );

        // Botões
        batch.draw(comer, BOTAO_COMER_X, BOTAO_Y, LARGURA_BOTAO, ALTURA_BOTAO);
        batch.draw(defender, BOTAO_DEFENDER_X, BOTAO_Y, LARGURA_BOTAO, ALTURA_BOTAO);
        batch.draw(dormir, BOTAO_DORMIR_X, BOTAO_Y, LARGURA_BOTAO, ALTURA_BOTAO);
        batch.draw(sair, BOTAO_SAIR_X, BOTAO_Y, LARGURA_BOTAO, ALTURA_BOTAO);

        //usado para encerrar o batch begin()
        batch.end();

        // Desenha a caixa preta transparente no topo para poder aparecer o dialogo
        desenharCaixaDeTexto();

        // Usado para escrever o texto da mensagem por cima da caixa
        batch.begin();
        fonte.draw(batch, mensagemStatus, 25, Gdx.graphics.getHeight() - 22);

        // Barra de vida e fome (tem que melhorar)
        fonte.draw(
            batch,
            "PV: " + (int)pet.getPv()
            + " | Fome: " + pet.getFome()
            + " | Felicidade: " + pet.getFelicidade()
            + " | Energia: " + pet.getEnergia(),
            20,
            25
        );

        batch.end();
    }

    private void desenharCaixaDeTexto() {
        Gdx.gl.glEnable(Gdx.graphics.getGL20().GL_BLEND);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Caixa preta da cor semitransparente usando a = 0.75
        shapeRenderer.setColor(0, 0, 0, 0.75f);

        float largura = Gdx.graphics.getWidth() - 20;
        float altura = 55;
        float x = 10;
        float y = Gdx.graphics.getHeight() - altura - 10;

        shapeRenderer.rect(x, y, largura, altura);
        shapeRenderer.end();
        Gdx.gl.glDisable(Gdx.graphics.getGL20().GL_BLEND);
    }

    //Metodo usado para poder aceitar os cliques do mouse
    private void processarEntradas() {

        //  Se ele receber o clique do mouse ele cai na condicao
        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();

            // Inverte a coordenada Y por que o libGDX conta de baixo pra cima
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            // Se Sair
            if (foiClicado(touchX, touchY, BOTAO_SAIR_X, BOTAO_Y)) {
                Gdx.app.exit();
                return;
            }

            if (!pet.getEstaVivo()) return;

            // Se Comer
            if (foiClicado(touchX, touchY, BOTAO_COMER_X, BOTAO_Y)) {
                acaoComer();
            }
            // Se Defender ou Levar Ataque
            else if (foiClicado(touchX, touchY, BOTAO_DEFENDER_X, BOTAO_Y)) {
                acaoDefender();
            }
            // Se Dormir
            else if (foiClicado(touchX, touchY, BOTAO_DORMIR_X, BOTAO_Y)) {
                acaoDormir();
            }
        }

        // Primeira tentativa usando apenas as teclas 1, 2, 3 e 4

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            Gdx.app.exit();
            return;
        }

        if (!pet.getEstaVivo()) return;
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) acaoComer();
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) acaoDefender();
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) acaoDormir();
    }

    private boolean foiClicado(float touchX, float touchY, float btnX, float btnY) {
        return touchX >= btnX
            && touchX <= btnX + LARGURA_BOTAO
            && touchY >= btnY
            && touchY <= btnY + ALTURA_BOTAO;
    }

    private void iniciarAnimacao(Texture primeiroSprite, Texture segundoSprite) {
        spriteAcao1 = primeiroSprite;
        spriteAcao2 = segundoSprite;
        spriteAtual = spriteAcao1;
        tempoAnimacao = 0f;
    }

    private void acaoComer() {
        iniciarAnimacao(comer1, comer2);

        mensagemStatus = pet.mastigar(comidaAtual);

        if (!pet.getEstaVivo()) {
            mensagemStatus = "Fim de jogo! Seu Tamagotchi infelizmente desmaiou!";
            return;
        }

        if (comidaAtual.getPv() <= 0) {
            String comidaMorta = comidaAtual.getTipo().name();
            comidaAtual = Randomizador.gerarNovoInimigo();

            mensagemStatus = "!!! VITORIA !!! Voce amassou o " + comidaMorta +
                "! Um novo prato chamado" + comidaAtual.getTipo() +  " veio ao resgate de seu ex-parceiro!";
        
            if (Randomizador.chance(25)) {
                Randomizador.trocarTalher(pet);
            }
        }
    }

    private void acaoDefender() {
        iniciarAnimacao(defender1, defender2);

        mensagemStatus = pet.defender();

        if (!pet.getEstaVivo()) {
            mensagemStatus = "Fim de jogo! Seu Tamagotchi infelizmente desmaiou!";
            return;
        }

        if (comidaAtual.getPv() > 0) {
            comidaAtual.atacar(pet);
            mensagemStatus = "O " + comidaAtual.getTipo() + " te atacou! Dano recebido.";

            if (!pet.getEstaVivo()) {
                mensagemStatus = "Fim de jogo! Seu Tamagotchi infelizmente desmaiou!";
            }
        }
    }

    private void acaoDormir() {
        iniciarAnimacao(dormir1, dormir2);

        mensagemStatus = pet.dormir();

        if (!pet.getEstaVivo()) {
            mensagemStatus = "Fim de jogo! Seu Tamagotchi infelizmente desmaiou!";
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        fonte.dispose();

        fundo.dispose();
        mimiSprite.dispose();
        comer.dispose();
        defender.dispose();
        dormir.dispose();
        sair.dispose();

        comer1.dispose();
        comer2.dispose();
        defender1.dispose();
        defender2.dispose();
        dormir1.dispose();
        dormir2.dispose();
    }
}