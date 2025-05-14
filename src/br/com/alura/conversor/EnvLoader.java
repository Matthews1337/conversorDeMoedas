package br.com.alura.conversor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class EnvLoader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(".env");
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Erro ao carregar .env: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

