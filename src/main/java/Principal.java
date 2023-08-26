import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        //CalculadoraParaConcole();

        CalculadoraParaImpressora();
    }
    private static void CalculadoraParaConcole() {
        CalculadoraConsole c = new CalculadoraConsole();

        c.apresentacaoCalculadora();
        String entrada = c.entradaDoUsuario();
        String resultado = c.recebeExpressaoDevolvendoResultado(entrada);
        c.imprimeNoConcole(resultado);
    }
    private static void CalculadoraParaImpressora() throws IOException {
        boolean metodoDeGravacao = true;
        CalculadoraArquivo f = new CalculadoraArquivo();

        System.out.println("Escolha modo de gravação: (1) append | (0) overwriter");
        String escolha = f.entradaDoUsuario();

        if(escolha.equals("1"))
            metodoDeGravacao=true;
        else
            metodoDeGravacao=false;

        f.apresentacaoCalculadora();
        String entrada = f.entradaDoUsuario();
        String resultao = f.recebeExpressaoDevolvendoResultado(entrada);
        f.imprimeEmArquivo(resultao, metodoDeGravacao);
    }
}
