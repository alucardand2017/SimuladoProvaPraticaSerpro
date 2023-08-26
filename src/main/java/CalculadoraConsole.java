import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraConsole extends CalculadoraAbstrata {
    @Override
    public String recebeExpressaoDevolvendoResultado(String expressao) {

        String parcela1 = primeiroTermo(expressao);
        String parcela2 = segundoTermo(expressao);

        double parcela1Num = Double.parseDouble(parcela1);
        double parcela2Num = Double.parseDouble(parcela2);

        String resultado = traducaoDaOperacao(parcela1Num, parcela2Num, expressao);

        return resultado;
    }

    public void apresentacaoCalculadora(){
        System.out.println("""
                Bem-vindo/a à calculadora console!
                2 mais 2
                2 menos 4
                3 vezes 2
                6 dividido por 2
                4 elevado a 2
                Escreva o seu cálculo com algum dos formatos acima:
                5 elevado a 2
                25
                                
                """);
    }
    public String entradaDoUsuario() {
        System.out.print("Expressao: ");
        Scanner entrada = new Scanner(System.in);
        return  entrada.nextLine();
    }
    public void imprimeNoConcole(String resultado) {
        System.out.println(resultado);
    }
    private static String segundoTermo(String expressao) {
        String aux = "";
        for(int i = expressao.length()-1; i > 0 ; i--){
            if(expressao.substring(i, expressao.length()).contains(" "))
                break;
            else
                aux = expressao.substring(i, expressao.length());
        }
        return aux;
    }
    private static String primeiroTermo(String expressao) {
        String aux = "";
        for(int i = 0; i < expressao.length() ; i++){
            if(expressao.substring(0, i).contains(" "))
                break;
            else
                aux = expressao.substring(0,i);
        }
        return aux;
    }
    private String traducaoDaOperacao(double parcela1Num, double parcela2Num, String expressao) {

        if(testaMais(expressao))
            return String.format("\n" + parcela1Num + " mais " + parcela2Num + " é igual a " + (parcela1Num+parcela2Num) + "\n");

        if(testaMenos(expressao))
            return String.format("\n" + parcela1Num + " menos " + parcela2Num + " é igual a " + (parcela1Num-parcela2Num) + "\n");

        if (testaDivisao(parcela1Num, parcela2Num, expressao))
            return String.format("\n" + parcela1Num + " dividido por " + parcela2Num + " é igual a " + parcela1Num / parcela2Num  + "\n");

        if(testaVezes(expressao))
            return String.format("\n" + parcela1Num + " vezes " + parcela2Num + " é igual a " + (parcela1Num*parcela2Num)  + "\n");

        if (testaElevadoA(parcela1Num, parcela2Num, expressao))
            return String.format("\n" + parcela1Num + " elevado a " + parcela2Num + " é igual a " + Math.pow(parcela1Num, parcela2Num)  + "\n");

        return "não foi identificado a operaçao escolhida";
    }

    private static boolean testaElevadoA(double parcela1Num, double parcela2Num, String expressao) {
        if (expressao.contains("elevado")){
            if(parcela1Num == 0 && parcela2Num <= 0)
                throw new IllegalArgumentException("Operação Ilegal");
            return true;
        }
        return false;
    }
    private static boolean testaVezes(String expressao) {
        return expressao.contains("vezes");
    }
    private static boolean testaDivisao(double parcela1Num, double parcela2Num, String expressao) {
        if(expressao.contains("dividido")){
            if(parcela2Num == 0)
                throw new IllegalArgumentException("Operação Ilegal");
            return true;
        }
        return false;
    }
    private static boolean testaMenos(String expressao) {
        return expressao.contains("menos");
    }
    private static boolean testaMais(String expressao) {
        return expressao.contains("mais");
    }

}
