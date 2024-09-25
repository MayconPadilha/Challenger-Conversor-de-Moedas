import model.Moeda;

public class CalcularConversao {

    public Double calcularConversao(Double valor, Moeda moeda) {
        return valor * moeda.conversion_rates().usd();
    }
    
}
