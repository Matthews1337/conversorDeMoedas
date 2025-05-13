package br.com.alura.conversor;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ConversorMoedas {

    Map<String, Double> taxasConversao;



    public double converterDePara(String moedaPrincipal, String moedaAlvo, double valor) throws IOException, InterruptedException {

        this.taxasConversao = respostaApi(moedaPrincipal);
        moedaAlvo = moedaAlvo.toUpperCase();
        if (!taxasConversao.containsKey(moedaAlvo)) {
            throw new IllegalArgumentException("Moeda não encontrada: " + moedaAlvo);
        }
        double taxa = taxasConversao.get(moedaAlvo);
        return valor * taxa;
    }

    public Map<String, Double> respostaApi(String moedaPrincipal) throws IOException, InterruptedException {
        API api = new API();
        Currency resposta = api.fetchHttp(moedaPrincipal);
        return resposta.conversion_rates();
    }
    
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        System.out.println("=== Conversor de Moedas ===");

        while (true){
            System.out.print("\nDigite a moeda de origem (ex: BRL) ou 'sair': ");
            opcao = scanner.nextLine().trim();

            if (opcao.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o conversor. Até mais!");
                break;
            }
            try {
                System.out.print("Digite a moeda de destino (ex: USD): ");
                String destino = scanner.nextLine().trim();

                System.out.print("Digite o valor a ser convertido: ");
                double valor = Double.parseDouble(scanner.nextLine());

                double convertido = converterDePara(opcao, destino, valor);
                System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, opcao.toUpperCase(), convertido, destino.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
//            } catch (NumberFormatException e) {
//                System.out.println("Erro: Valor inválido.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }

}
