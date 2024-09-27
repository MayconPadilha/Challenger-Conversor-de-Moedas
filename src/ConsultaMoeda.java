import com.google.gson.Gson;
import model.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {
    public Moeda buscaMoeda(String moeda) {

        try {
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/7873f632daa51a3024ac18cc/latest/" + moeda);

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body().toLowerCase();

      return new Gson().fromJson(json, Moeda.class);

    } catch(IOException | InterruptedException e) {
      throw new RuntimeException("Não foi possível buscar os dados da API", e);
    }

  }
}
