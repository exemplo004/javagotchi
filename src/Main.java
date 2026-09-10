void main() {
    Scanner sc = new Scanner(System.in);

    String entrada;

    while(true) {
        System.out.println("Escolha um nome para o seu Tamago: ");
        entrada = sc.nextLine();
        System.out.println(entrada); // DONKEY

        if (entrada.isEmpty()) { System.out.println("Nome invahlido!"); }
        else break;
    }

    Tamago tama = new Tamago(entrada);
    System.out.println(tama);
}
