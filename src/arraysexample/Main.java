package arraysexample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo de colección . Arrays estructura fija
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        /*
          El operador [] permite definir el array de personas y un limite fijo.
         */
        Personas[] arraysPersonas = new Personas[10];
        arraysPersonas[0] = new Personas("Pepiton", 6);
        arraysPersonas[1] = new Personas("Pepitilla",6);

        /*
          para el array hay que realizar un bucle
         */
//        for (int i = 0; i < arraysPersonas.length; i++) {
//            String message = "" + arraysPersonas[i].getNombre();
//            logger.log(Level.CONFIG,message);
//
//        }
        for (Personas arraysPersona : arraysPersonas) {
            String message = "" + arraysPersona.getNombre();
            logger.log(Level.CONFIG, message);

        }
    }
}
