package helloworld;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("hola mundo");
        Personas p = new Personas("Mayte", 42);
        p.saludar();
        String texto = "Este es ,un verano azul";
        String mayusculas = texto.toUpperCase();
        String  textoCorto = mayusculas.substring(5);
        String textoRemplazado = textoCorto.replace(",",".");
        System.out.println(textoRemplazado);
        String resultado = texto.toUpperCase()
                                .substring(5)
                                .replace(",",".");
        System.out.println(resultado);
    }
}
