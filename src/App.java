import model.Moeda;

public class App {
 
    public static void main(String[] args) {

        Double valor = 1000.00;

        ConsultaMoeda consultaMoeda = new ConsultaMoeda();

        //moeda a ser convertida
        Moeda moeda = consultaMoeda.buscaMoeda("BRL");

        CalcularConversao calcularConversao = new CalcularConversao();
        valor = calcularConversao.calcularConversao(valor, moeda);

        System.out.println(valor);

    }
}
