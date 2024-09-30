package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {
  private static Map<String, String> vars;

  // Método para carregar o arquivo .env
  public static Map<String, String> loadEnvFile(String filePath) {
    Map<String, String> envVariables = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // Ignora linhas vazias ou comentários
        if (line.trim().isEmpty() || line.trim().startsWith("#")) {
          continue;
        }

        // Divide a linha na chave e valor
        String[] keyValue = line.split("=", 2);
        if (keyValue.length == 2) {
          String key = keyValue[0].trim();
          String value = keyValue[1].trim();

          // Adiciona ao map de variáveis
          envVariables.put(key, value);
        }
      }
    } catch (IOException e) {
      System.err.println("Erro ao carregar o arquivo .env: " + e.getMessage());
    }
    vars = Map.copyOf(envVariables);
    return envVariables;
  }

  public static String get(String key) {
    return vars.getOrDefault(key, null);
  }

}
