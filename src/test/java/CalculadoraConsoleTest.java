import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CalculadoraConsoleTest {

    @Test
    public void testaOsExemplosDosRequisitosIniciais() {
        CalculadoraConsole c = new CalculadoraConsole();

        Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado("1 mais 2").equals("1.0 mais 2.0 é igual a 3.0"));
        Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado("2 menos 3").equals("2.0 menos 3.0 é igual a -1.0"));
        Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado("4 dividido por 1").equals("4.0 dividido por 1.0 é igual a 4.0"));
        Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado("2 vezes 4").equals("2.0 vezes 4.0 é igual a 8.0"));
        Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado("3 elevado a 2").equals("3.0 elevado a 2.0 é igual a 9.0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.recebeExpressaoDevolvendoResultado("0 elevado a -2"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.recebeExpressaoDevolvendoResultado("8 dividido por 0"));

    }
    @Test
    public void batchFinalDeTestes() {
        CalculadoraConsole c = new CalculadoraConsole();

        for (int i = -100; i < 0; i++) {

            double x = i + 100*Math.random();
            double y = i + 100*Math.random();
            Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado(x + " mais " + y).equals(x + " mais " + y +" é igual a "+ (y + x)));
            Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado(x + " menos " + y).equals(x + " menos "+ y + " é igual a " + (x - y)));
            if(y == 0.0){
                Assertions.assertThrows(IllegalArgumentException.class, () -> c.recebeExpressaoDevolvendoResultado( x + " dividido por " + y));
            }else {
                Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado(x + " dividido por " + y).equals(x + " dividido por " + y +" é igual a " + ( x / y )));
            }
            Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado(x + " vezes " + y).equals(x + " vezes "+ y + " é igual a " + (x * y)));
            if(x == 0.0 && y <= 0.0){
                Assertions.assertThrows(IllegalArgumentException.class, () -> c.recebeExpressaoDevolvendoResultado(x + " elevado a " + y));
            }
            else {
                Assertions.assertTrue(c.recebeExpressaoDevolvendoResultado(x + " elevado a " + y).equals( x + " elevado a " + y + " é igual a " + Math.pow(x,y)));
            }
        }
    }
}

