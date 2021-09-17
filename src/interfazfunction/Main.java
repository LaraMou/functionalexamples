package interfazfunction;

/**
 * Interfaz
 * Método apply(obj) recibe un objeto un tipo determinado
 * de un parametro de un tipo y pasar a otro.
 * ej. un tipo persona y recibir una lista
 * otros tipos como consumer que tienen metodos andThen , compose
 * enlazan funciones o componen funciones
 * Interfaz funtion<T,R> tipo objeto y retorno
 *
 * Interfaz Bifunction, metodo apply(obj1,obj2) de mismo o distinto tipo de objeto y obtenemos un retorno
 * esta interfaz la combinados y hacer operaciones complejas con andThen o compose, y otros subtipos
 *
 */



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Ejemplo con Bifunction: Una lista de Personas a partir de una edad, obj1(Personas), obj2(int)
 * retorno la lista de esas personas filtradas
 *
 * Si es para Function, un obj1 de Lista de personas y retorna un String formateada
 *
 * Otra es ya unificar ambas
 */
public class Main {
    private static List<Personas> personasList  = new ArrayList<>();
    public static void main(String[] args) {

        personasList.add(new Personas("Juan",44));
        personasList.add(new Personas("Ana",44));
        personasList.add(new Personas("Matias",30));
        personasList.add(new Personas("Pepito",10));

        //Bifunction filtra personas por edad
        BiFunction<List<Personas>,Integer, List<Personas>> minEdad = (lista,edad)->
        {
            List<Personas> resultado = new ArrayList<>();
            for(Personas p:lista)
            {
                if(p.getEdad()>= edad)
                {
                    resultado.add(p);
                }
            }
            return resultado;
        };
        List<Personas> mayores16 = minEdad.apply(personasList,16);
        System.out.println("Personas mayores de 16: ");
        for(Personas p : mayores16){
            System.out.println(p);
        }

        // para mostrar funcion por pantalla, se llama a la función metodo apli con el parametro de lista
        System.out.println("Nombres separados por comas: ");
        // se va acombinar

        //escribir en fichero
     //   escribirFichero();
        Function<List<Personas>,String> listaAString = lista->
        {
            String result = "";
            for (int i = 0; i < lista.size(); i++) {
                if(i< lista.size() -1)
                    result += lista.get(i).getNombre() + ", ";
                else
                    result += lista.get(i).getNombre();

            }
            return  result;
        };
         System.out.println(listaAString.apply(personasList));

        //comibinadas
        BiFunction<List<Personas>,Integer,String> biFunctionfunction = minEdad.andThen(listaAString);
        System.out.println("Nombres de mayores de 16 ");
        System.out.println(biFunctionfunction.apply(personasList,16));
  }

    private static void escribirFichero() {
        System.out.println("Escribir en el fichero bifunción concatenada");

        System.out.println("Fichero texto");
        Function<List<Personas>,String> listaAString = lista->
        {
            String result = "";
            for (int i = 0; i < lista.size(); i++) {
                if(i< lista.size() -1)
                    result += lista.get(i).getNombre() + ", ";
                else
                    result += lista.get(i).getNombre();

            }
            return  result;
        };
        try{
            BufferedWriter ficheroSalida = new BufferedWriter(
                    new FileWriter(new File("fichero.txt")));
            ficheroSalida.write(listaAString.apply(personasList));
            ficheroSalida.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
