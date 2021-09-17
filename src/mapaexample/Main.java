package mapaexample;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Mapas son colecciones No se almacenan los datos consecutivamente, sino se identifica mediante una clave.
Interfaz Map , la clave será un String, y el valor son los objetos de tipo persona .
Los parejas de clave valor.
Como no hay indice se ha de obtener el keyset (conjunto
 */
public class Main {
    private static final Logger logger = Logger.getLogger(arraysexample.Main.class.getSimpleName());
    public static void main(String[] args) {
        Map<String,Personas> personasMap = new HashMap<>();
        personasMap.put("111a", new Personas("Nacho",42));
        personasMap.put("222b", new Personas("Julia",55));
        personasMap.put("333c", new Personas("Ana",32));
        personasMap.put("444d", new Personas("Antolin",2));
        
        /*
        No se almacenan los datos consecutivamente, sino se identifica mediante una clave.
        Se recorrer con el foreach el conjunto de claves que están en el KeySet
        se obitene con el método get el objeto de la persona
         */
        for (String clave : personasMap.keySet()
             ) {
            Personas personas = personasMap.get(clave);
            String message = "" + personas.getNombre();
            logger.log(Level.INFO,message);
        }
    }
}
