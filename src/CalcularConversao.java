import model.Moeda;

public class CalcularConversao {

  public Double calcularConversao(Double valorOriginal, Moeda moeda, EnumMoeda moedaAlvo) {

    System.out.println("Conversão de " + moeda.base_code() + " para " + moedaAlvo);

    Double taxaConversao = moeda.conversion_rates().get(moedaAlvo.toString());

    System.out.println("Taxa de conversão: " + taxaConversao);

    return valorOriginal * taxaConversao;
  }

}
