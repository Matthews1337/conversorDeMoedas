
import br.com.alura.conversor.ConversorMoedas;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        ConversorMoedas conversor = new ConversorMoedas();
        conversor.run();
//        System.out.println(conversor.converterDePara("USD", "BRL", 25));

    }
}