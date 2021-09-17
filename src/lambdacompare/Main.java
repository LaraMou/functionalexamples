package lambdacompare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
   private static  List<Personas> list = new ArrayList<>();
   static List<Personas> filtrar(List<Personas> personas, Predicate<Personas> predicate){
       List<Personas> resultado = new ArrayList<>();
       for(Personas p: personas){
           if(predicate.test(p))
           {
               resultado.add(p);
           }
       }
       return resultado;
   }
    public static void main(String[] args) {

        list.add(new Personas("Lucas",12));
        list.add(new Personas("Julia",10));
        list.add(new Personas("Monica",6));
        list.add(new Personas("Juanito",6));
        compare();
        prediate();
        filtrar();
    }

    private static void filtrar() {
       List<Personas> adultos = filtrar(list,p -> p.getEdad() >=10);

        System.out.println("Listado de mayores de 10");
        for(Personas p : adultos){
            System.out.println(p);
        }
        List<Personas> empieza = filtrar(list,p -> p.getNombre().startsWith("L"));
        System.out.println("Listado de mayores de 10");
        for(Personas p : empieza){
            System.out.println(p);
        }
        Predicate<Personas> padulto = p-> p.getEdad() >=10;
        Predicate<Personas> pNombreM = p-> p.getNombre().startsWith("M");
        List<Personas> personas = filtrar(list,padulto.and(pNombreM));
        System.out.println("filtros varios");
        for(Personas p: personas){

                System.out.println("hola"+p);
        }
    }

    private static void prediate() {
        Predicate<Personas> adulto = p-> p.getEdad()>=10;
        System.out.println(adulto.test(list.get(0)));
    }

    private static void compare() {
        ComparePersonas cp = new ComparePersonas();
        list.sort(cp);
        System.out.println("Personas ordenadas de menor a mayor");
        for(Personas p: list){
            System.out.println(p);
        }
        //comparar de mayor a menor
        list.sort(new Comparator<Personas>() {
            @Override
            public int compare(Personas o1, Personas o2) {
                return o2.getEdad() - o1.getEdad();
            }
        });
        System.out.println("Personas ordenadas de mayor a menor");
        for(Personas p: list){
            System.out.println(p);
        }
        //ordenar alfabeticamente nombre
        list.sort((o1,o2)-> o1.getNombre().compareTo( o2.getNombre()));
        System.out.println("Personas ordenadas alfabeticamenter");
        for(Personas p: list){
            System.out.println(p);
        }
        //ordenar alfabeticamente nombre
        list.sort((o1,o2)-> o2.getNombre().compareTo( o1.getNombre()));
        System.out.println("Personas ordenadas alfabeticamenter");
        for(Personas p: list){
            System.out.println(p);
        }

        //comparar por edad si iguales nombre
        Comparator<Personas> cEdad = (p1,p2)-> p1.getEdad() -p2.getEdad();
        Comparator<Personas> cNombre = (p1,p2)-> p1.getNombre().compareTo(p2.getNombre());
        list.sort(cEdad.thenComparing(cNombre));
        System.out.println("Si edad igual , comparar nombre");
        for(Personas p: list){
            System.out.println(p);
        }

    }
}
