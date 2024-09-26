import model.Moeda;

public class App {
 
    public static void main(String[] args) {

        Double valorOriginal = 1000.00;

        ConsultaMoeda consultaMoeda = new ConsultaMoeda();

        Moeda moeda = consultaMoeda.buscaMoeda("BRL");

        String moedaAlvo = "EUR";

        CalcularConversao calcularConversao = new CalcularConversao();
        Double valorConvertido = calcularConversao.calcularConversao(valorOriginal, moeda, moedaAlvo.toLowerCase());

        System.out.println("Valor convertido: " + valorConvertido);

    }
}
