package ejercicio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) {
        ArrayList<Examen> examen = new ArrayList<>();
        examen.add(new Examen("Mate",5D));
        examen.add(new Examen("Lengua",5D));

        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Acapulco",5));
        hotels.add(new Hotel("Maritimo",2));

        for (Examen exa: examen
             ) {
            logger.log(Level.INFO, "Result {0}.", exa.getName());
            mostrarInformacion(exa);
            
        }
        for (Hotel hotel: hotels
        ) {
            logger.log(Level.INFO, "Result {0}.", hotel.getName());
            mostrarInformacion(hotel);

        }

        /*nuevo elemente

         */
        mostrarInformacion(new Calificable() {
           static final String NAME = "Pepete Bar";
            static final Double[] tenedores = {1d,2d,3d,4d};
            @Override
            public Double calificado() {
               logger.log(Level.INFO,NAME);
                return tenedores[0];
            }
        });

    }
     static void mostrarInformacion(Calificable f){
        String message = "La calificación es " +  f.calificado();
        logger.log(Level.INFO, message);


    }
}
