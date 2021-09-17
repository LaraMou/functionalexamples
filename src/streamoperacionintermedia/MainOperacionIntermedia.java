package streamoperacionintermedia;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainOperacionIntermedia {
    public static void main(String[] args) {
        List<Personas> personasList = new ArrayList<>();
        personasList.add(new Personas("Nacho M", 42));
        personasList.add(new Personas("Pepiton ", 44));
        personasList.add(new Personas("Nacho", 11));
        personasList.add(new Personas("Juan Antonio 31", 31));
        personasList.add(new Personas("Jose Antonio", 61));
        personasList.add(new Personas("Jamiita Antonio", 15));
        personasList.add(new Personas("Juan Antonio", 71));

        personasList.add(new Personas("Lucas", 22));
        personasList.add(new Personas("Lucas", 22));
        personasList.add(new Personas("Esteban", 22));
        System.out.println("Listado de personas con mas edad: ");

        // se van a enlazar operaciones intermedia
        //ordenar las personas de mayor a menor edad
        // me quedo con las tres primeras
        // me quedo con su nombre
        personasList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad()))
                .filter(p -> p.getNombre().startsWith("J"))
                .skip(2)
                .map(p -> p.getNombre())
                .forEach(System.out::println);

        //obtener una lista collect
        List<Personas> list = personasList.stream()
                                            .filter(p -> p.getEdad() >= 30)
                                            .collect(Collectors.toList());
        System.out.println("Lista Operación lista y collector");
        for(Personas p : list)
            System.out.println(p);

        //collector joining.
        //obtener nombres separados por comas de las personas adultas del listado
        String adultos = personasList.stream()
                                    .filter(p-> p.getEdad() >= 18)
                                    .map(p-> p.getNombre())
                                    .collect(Collectors.joining(",","Nombres separados: ",". Fin"));
        System.out.println(adultos);

    }

}
