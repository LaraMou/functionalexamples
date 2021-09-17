package listaexample;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /*
    Se dispone de una interfaz java List y tras <> se indica el tipo y luego la clase concreta ArrayList
    los métodos de interfaz y de la clase :
     - add para añadir las personas
     - remove y el indice
     - size y el metodo get


     */
    private static final Logger logger = Logger.getLogger(arraysexample.Main.class.getSimpleName());
    public static void main(String[] args) {
        List<Personas> personasList = new ArrayList<>();
        personasList.add(new Personas("Nacho", 42));
        personasList.add(new Personas("Pepiton ", 44));
        personasList.add(new Personas("Lucas", 11));

//        for (int i = 0; i < personasList.size(); i++) {
//            String message = "" + personasList.get(i).getNombre();
//            logger.log(Level.INFO,message);
//        }
        for (Personas listapersonas: personasList) {
            String message = "" + listapersonas.getNombre();
              logger.log(Level.INFO,message);
            
        }

    }
}
