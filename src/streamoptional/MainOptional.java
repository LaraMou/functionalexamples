package streamoptional;

import streamoperacionintermedia.Personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class MainOptional {
    public static void main(String[] args) {
        List<streamoperacionintermedia.Personas> personasList = new ArrayList<>();
        personasList.add(new streamoperacionintermedia.Personas("Nacho M", 81));
        personasList.add(new streamoperacionintermedia.Personas("Pepiton ", 42));
        personasList.add(new streamoperacionintermedia.Personas("Nacho", 15));
        personasList.add(new streamoperacionintermedia.Personas("Juan Antonio 31", 24));
        personasList.add(new streamoperacionintermedia.Personas("Jose Antonio", 45));
        personasList.add(new streamoperacionintermedia.Personas("Jamiita Antonio", 44));
        personasList.add(new Personas("Juan Antonio", 41));
        Optional<Personas> mayor = personasList.stream().max((p1, p2)->Integer.compare(p1.getEdad(), p2.getEdad()));
        Optional<Personas> menor = personasList.stream().min((p1, p2)->Integer.compare(p1.getEdad(), p2.getEdad()));
        if(mayor.isPresent() ) {
            System.out.println(" Existe una persona con los requisitos " + mayor.get());
        }
        else
        {
            System.out.println("no cumple con el requisito");
        }

        OptionalDouble  edades = personasList.stream().mapToInt(p ->p.getEdad()).average();
        if(edades.isPresent())
            System.out.println("La edad media es : "+edades.getAsDouble());
        else
            System.out.println("no existen datos");

        OptionalDouble edadesfiltradas = personasList.stream()
                                                    .filter(p->p.getEdad()>=100)
                                                    .mapToInt(p->p.getEdad()).average();
        if(edadesfiltradas.isPresent())
            System.out.println("La edad media de todos los adultos es"+ edadesfiltradas.getAsDouble());
        else
            System.out.println("no existen datos a mostrar");
    }
}
