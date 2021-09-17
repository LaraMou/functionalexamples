package lambdaconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase Principal para trabajar con la interfaz consumer
 * Unico método accept: procedimiento void. Solo devuelve
 * Operaciones sacar objeto por pantalla, fichero  , volcado a una base de datos.
 *
 * el mëtodo andThen preimplementado que pasa los objetos de un consumer a otro para que hagan cosas
 *
 *
 */
public class MainConsumer {
    static void procesar(List<Personas> personas,Consumer<Personas> c){
        for(Personas p : personas){
            c.accept(p);
        }
    }
    public static void main(String[] args) {
        List<Personas> personasList  = new ArrayList<>();
        personasList.add(new Personas("Juan",44));
        personasList.add(new Personas("Ana",44));
        personasList.add(new Personas("Matias",30));
        personasList.add(new Personas("Pepito",10));

        /*
        se importa del paquete java.util.function.consumer la clase correspondiente
        Consumer para reconocimiento del compilador
        este Consumer se denominará imprimir, que recibe una persona y la saca por pantalla.

         */
//        Consumer<Personas> imprimir = p -> System.out.println(p);
        //más reducido ya que el parametro que se  recibe se pasa a la funcion que
        // se va utilizar. se puede abreviar la expresión lambda
        // se recibe a la función se le pasa directamente al metodo println.
        Consumer<Personas> imprimir = System.out::println;
        procesar(personasList,imprimir);

        //consumir este con un for


    }

}
