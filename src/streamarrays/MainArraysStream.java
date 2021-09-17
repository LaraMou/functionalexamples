package streamarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainArraysStream {
    public static void main(String[] args) {
        Personas[] arrayPersonas = new  Personas[4];
        arrayPersonas[0]  = new Personas("Nacho", 42);
        arrayPersonas[1]  = new Personas("Pancho", 52);
        arrayPersonas[2]  = new Personas("Maria", 4);
        arrayPersonas[3]  = new Personas("Jancito", 92);

        //obtener otro array en lugar de lista
        List<Personas> adultos = Arrays.stream(arrayPersonas)
                                        .filter(p->p.getEdad()>=18)
                                        .collect(Collectors.toList());

        // en este caso que el stream es de tipo array, es necesario este objeto tipo arrray con el tamaño del
        // nuevo array creado
        Personas[] adultos2 = Arrays.stream(arrayPersonas)
                .filter(p->p.getEdad()>=18)
                .toArray(tam-> new Personas[tam]);
        for(Personas p : adultos2)
            System.out.println(p);

        //stream en mapas.
        // al estar formada por un conjunto de entradas, mediante el entrySet   y así se puede aplicar el stream
        // tambien en los mapas se puede obtener los valore  o las claves keySet y aplicar los streams por separado

        Map<String, Personas> personasMap = new HashMap<>();
        personasMap.put("111A",new Personas("Antonlin",14));
        personasMap.put("555B",new Personas("Marisa Gallardo",35));
        personasMap.put("333T",new Personas("Gabino Gallardo",25));
        personasMap.put("679H",new Personas("Cristobalin",75));
        List<Personas> listamap = personasMap.values()
                                            .stream()
                                            .filter(p-> p.getEdad()>=18)
                                            .collect(Collectors.toList());
        for(Personas p : listamap)
            System.out.println(p);

        System.out.println("Entry set");
        List<String> dnimap = personasMap.entrySet()
                .stream()
                .filter(p-> p.getValue().getEdad()>=18) // el filter recoge todo el objeto persona
                .map(Map.Entry::getKey) // se mapea la clave
                .collect(Collectors.toList());
        for(String p : dnimap)
            System.out.println(p);
    }
}
