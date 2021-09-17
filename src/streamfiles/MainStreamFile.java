package streamfiles;

import javax.imageio.IIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreamFile {
    public static void main(String[] args) {
        try{
            //las lineas leidas se mapean la primera palabra separada por los dos puntos es el nombre
            // la segunda palabra es la eda que se pasa a integer.
            // este string lo pasamos a una lista
            List<Personas> personasLis =
            Files.lines(Paths.get("personas.txt"))
                    .map(line->new Personas(line.split(":")[0],Integer.parseInt(line.split(":")[1])))
                    .collect(Collectors.toList());

        }
        catch (Exception exception)
        {
            System.out.println("Error procesando archivos "+exception.getLocalizedMessage());
        }

    }
}
