package ejercicio2;

import lambdacompare.Personas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MainEjercicioSeccion2 {
    private static  List<Pelicula> peliculas = new ArrayList<>();
    static void mostrar(List<Pelicula> peliculas, Consumer c)
    {
        for(Pelicula p : peliculas)
            c.accept(p);
    }

    public static void main(String[] args)
    {

        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        ordenar();
    }

    private static void ordenar() {
        Consumer<Pelicula> peliculaConsumer = System.out::println;
        peliculas.sort((p1,p2)->Integer.compare(p2.getEstreno(), p1.getEstreno()));
        System.out.println("Peliculas ordenas");
        mostrar(peliculas,peliculaConsumer);
        //comparar por edad si iguales nombre
        Comparator<Pelicula> cDirector = (p1,p2)-> p1.getDirector().compareTo(p2.getDirector());
        Comparator<Pelicula> cEstreno = (p1,p2)-> p2.getTitulo().compareTo (p1.getTitulo());
        peliculas.sort(cDirector.thenComparing(cEstreno));
        System.out.println("Salida ");
       mostrar(peliculas,peliculaConsumer);
    }

}
