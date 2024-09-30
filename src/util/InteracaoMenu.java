package util;

import model.EnumMoeda;
import model.Moeda;

public class InteracaoMenu {
    String mensagemOpcao = "Qual moeda deseja converter? ";
    String mensagemOpcaoErro = "Valor inválido. Tente novamente.\n";
    String mensagemErro = "Valor inválido. Tente novamente.\n";
    int opcaoMoeda;

    InputValidate inputValidate = new InputValidate();

    EnumMoeda[] moedas = EnumMoeda.values();

    public void realizarConversaoDeMoedas(int opcao) {
        moedas();
        opcaoMoeda = inputValidate.inputNumberValidate(1, moedas.length, mensagemOpcao, mensagemOpcaoErro);
        EnumMoeda moedaSelecionada = moedas[--opcaoMoeda];

        ConsultaMoeda consultaMoeda = new ConsultaMoeda();
        Moeda moeda = consultaMoeda.buscaMoeda(moedaSelecionada);

        String mensagem = "Qual valor deseja converter? ";
        Double valorOriginal = inputValidate.inputNumberValidate(0.1, Double.MAX_VALUE, mensagem, mensagemErro);

        moedas();
        mensagemOpcao = "Selecione a moeda da conversão: ";
        opcaoMoeda = inputValidate.inputNumberValidate(1, moedas.length, mensagemOpcao, mensagemOpcaoErro);
        EnumMoeda moedaAlvo = moedas[--opcaoMoeda];

        CalcularConversao calcularConversao = new CalcularConversao();
        Double valorConvertido = calcularConversao.calcularConversao(valorOriginal, moeda, moedaAlvo);

        System.out.println("Valor convertido: " + valorConvertido);
    }

    public static void moedas() {
        EnumMoeda.mostrar();
    }

}
