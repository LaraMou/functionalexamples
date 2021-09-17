package lambda;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(ejercicio.Main.class.getSimpleName());
    public static void main(String[] args) {
        int n = 0;
        Serie5 s5 = new Serie5();
        for (int i = 0; i < 10; i++) {
            logger.log(Level.WARNING,"Los numeros de 5 en 5 : " + n);
            n = s5.siguiente(n);
        }
        Serie s5b = new Serie() {
            @Override
            public int siguiente(int n) {
                return n + 5;
            }

        };
        n = 0;
        for (int i = 0; i < 10; i++) {
            logger.log(Level.WARNING,"Clase anonima de 5 en 5 : " + n);
            n = s5b.siguiente(n);
        }
        // Si la expresión lambda solo tiene un parametro se le puede quitar
        // si la funcion a implmentar es de un unico dato se quedaría  más reducido
//        Serie s5c = (num) -> {
//            return num + 5;
//        };
        Serie s5c = num -> num + 5;
        n = 0;
        for (int i = 0; i < 10; i++) {
            logger.log(Level.WARNING,"Lambda 5 en 5 : " + n);
            n = s5c.siguiente(n);
        }
    }

}

