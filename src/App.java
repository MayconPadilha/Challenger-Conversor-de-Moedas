import model.Moeda;

import java.util.Scanner;

public class App {

  private static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    boolean exit = false;
    String mensagemOpcao = "";
    String mensagemOpcaoErro = "";

    EnumMoeda[] moedas = EnumMoeda.values();

    while(!exit) {
      menu();

      mensagemOpcao = "Qual sua opcao? ";
      mensagemOpcaoErro = "Valor inválido. Tente novamente.\n";
      int opcao = inputNumberValidate(1, 2, mensagemOpcao , mensagemOpcaoErro);

      switch(opcao) {
        case 1:
          moedas();
          mensagemOpcao = "Qual sua opcao? ";
          mensagemOpcaoErro = "Valor inválido. Tente novamente.\n";

          int opcaoMoeda = inputNumberValidate(1, moedas.length, mensagemOpcao , mensagemOpcaoErro);
          EnumMoeda moedaSelecionada = moedas[--opcaoMoeda];

          ConsultaMoeda consultaMoeda = new ConsultaMoeda();
          Moeda moeda = consultaMoeda.buscaMoeda(moedaSelecionada);

          String mensagem = "Qual valor deseja converter?";
          String mensagemErro = "Valor inválido. Tente novamente.\n";
          Double valorOriginal = inputNumberValidate(0.1, Double.MAX_VALUE, mensagem , mensagemErro);

          moedas();
          mensagemOpcao = "Qual sua opcao? ";
          mensagemOpcaoErro = "Valor inválido. Tente novamente.\n";
          opcaoMoeda = inputNumberValidate(1, moedas.length, mensagemOpcao , mensagemOpcaoErro);
          EnumMoeda moedaAlvo = moedas[--opcaoMoeda];

          CalcularConversao calcularConversao = new CalcularConversao();
          Double valorConvertido = calcularConversao.calcularConversao(valorOriginal, moeda, moedaAlvo);

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
        Selecione o número da opção:

        1. Converter
        2. Sair

        ***********************
        """);
  }

  public static void moedas() {
    EnumMoeda.mostrar();
  }

  private static int inputNumberValidate(int startWith, int endWith, String question, String messageError) {
    if(startWith > endWith) {
      int tmp = startWith;
      startWith = endWith;
      endWith = tmp;
    }
    int option;
    while(true) {
      try {
        System.out.print(question);
        option = Integer.parseInt(scan.nextLine());
        if(option >= startWith && option <= endWith) return option;
        else throw new IllegalArgumentException();
      } catch(Exception e) {
        System.err.print(messageError);
      }
    }
  }

  private static double inputNumberValidate(double startWith, double endWith, String question, String messageError) {
    if(startWith > endWith) {
      double tmp = startWith;
      startWith = endWith;
      endWith = tmp;
    }
    double option;
    while(true) {
      try {
        System.out.print(question);
        option = Double.parseDouble(scan.nextLine().replaceAll(",", "."));
        if(option >= startWith && option <= endWith) return option;
        else throw new IllegalArgumentException();
      } catch(Exception e) {
        System.err.print(messageError);
      }
    }
  }
}
