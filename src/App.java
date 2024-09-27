import model.Moeda;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    boolean exit = false;

    while(!exit) {
      menu();

      int opcao = scan.nextInt();

      switch(opcao) {
        case 1:
          moedas();
          int opcaoMoeda = scan.nextInt();

          String[] moedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD", "EUR"};
          String moedaSelecionada = moedas[--opcaoMoeda];

          ConsultaMoeda consultaMoeda = new ConsultaMoeda();
          Moeda moeda = consultaMoeda.buscaMoeda(moedaSelecionada);

          System.out.print("Qual valor deseja converter? ");
          Double valorOriginal = scan.nextDouble();

          moedas();
          opcaoMoeda = scan.nextInt();
          String moedaAlvo = moedas[--opcaoMoeda];

          CalcularConversao calcularConversao = new CalcularConversao();
          Double valorConvertido = calcularConversao.calcularConversao(valorOriginal, moeda, moedaAlvo.toLowerCase());

          System.out.println("Valor convertido: " + valorConvertido);

          break;
        case 2:
          exit = true;
          scan.close();
          break;

        default:
          System.out.println("Opção inválida");
          break;
      }
    }

  }

  public static void menu() {
    System.out.println("""
        ***********************
        Selecione uma opção:

        1. Converter
        2. Sair

        ***********************
        """);
  }

  public static void moedas() {
    System.out.println("""
        ***********************
        Selecione uma opção:

        1. ARS - Peso argentino
        2. BOB - Boliviano boliviano
        3. BRL - Real brasileiro
        4. CLP - Peso chileno
        5. COP - Peso colombiano
        6. USD - Dólar americano
        7. EUR - Euro

        ***********************
        """);
  }
}
