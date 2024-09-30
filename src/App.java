import util.InputValidate;
import util.InteracaoMenu;

import java.util.Scanner;

public class App {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        InteracaoMenu interacaoMenu = new InteracaoMenu();

        InputValidate inputValidate = new InputValidate();

        while (!exit) {
            menu();
            String mensagemOpcao = "Qual sua opcao? ";
            String mensagemOpcaoErro = "Valor inválido. Tente novamente.\n";
            int opcao = inputValidate.inputNumberValidate(1, 2, mensagemOpcao, mensagemOpcaoErro);

            switch (opcao) {
                case 1:
                    interacaoMenu.realizarConversaoDeMoedas();
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
}
