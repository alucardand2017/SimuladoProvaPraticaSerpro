import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CalculadoraArquivo extends CalculadoraConsole{

    public void imprimeEmArquivo(String dados, boolean appendMethod) throws IOException {
        File file = new File("output.txt");
        FileWriter fileWriter = new FileWriter(file, appendMethod);
        fileWriter.write(dados);
        fileWriter.close();
        System.out.println("Dados salvos!");
    }

}
