package br.com.alura.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public Currency fetchHttp(String moeda) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        moeda = moeda.toUpperCase();
        String apiKey = EnvLoader.get("EXCHANGE_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API KEY não encontrada no arquivo .env");
        }

        String uri = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moeda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                return gson.fromJson(response.body(), Currency.class);
//                return response;
            }else{
                throw new IOException("HTTP error: " + response.statusCode());
            }

    }


}
