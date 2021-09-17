package streamsreduce;

import streams.Personas;

import java.util.ArrayList;
import java.util.List;

public class MainReduce {
    public static void main(String[] args) {
        List<streams.Personas> personasList = new ArrayList<>();
        personasList.add(new streams.Personas("Nacho", 42));
        personasList.add(new streams.Personas("Pepiton ", 44));
        personasList.add(new streams.Personas("Nacho", 11));
        personasList.add(new streams.Personas("Juan Antonio", 31));
        personasList.add(new streams.Personas("Lucas", 22));
        personasList.add(new Personas("Esteban", 22));
        System.out.println("Listado de personas con sStreams::");

        // reduce el acumulador el valor inicial , en este caso cero

        int sumEdades = personasList.stream()
                    .mapToInt(p -> p.getEdad())
                    .reduce(0,(e1,e2)-> e1+e2);
        System.out.println("Suma de edades :"+ sumEdades);

        if(personasList.stream().allMatch(p->p.getEdad()>=18))
            System.out.println("Todos adultos ");
        else
            System.out.println("existe un menor");
    }
}
