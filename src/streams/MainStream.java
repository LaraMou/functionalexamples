package streams;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainStream {
    public static void main(String[] args) {
        List<Personas> personasList = new ArrayList<>();
        personasList.add(new Personas("Nacho", 42));
        personasList.add(new Personas("Pepiton ", 44));
        personasList.add(new Personas("Nacho", 11));
        personasList.add(new Personas("Juan Antonio", 31));
        personasList.add(new Personas("Lucas", 22));
        personasList.add(new Personas("Esteban", 22));
        System.out.println("Listado de personas con sStreams::");
        Comparator<Personas> cEdad = (p1,p2)->Integer.compare(p2.getEdad(),p1.getEdad());
        Comparator<Personas> cNombre = (p1,p2) ->p1.getNombre().compareTo(p2.getNombre());
        personasList.stream()
                .sorted((cEdad.thenComparing(cNombre)))
                .forEach(System.out::println);


    }
}
