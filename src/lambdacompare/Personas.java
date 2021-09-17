package lambdacompare;

public class Personas {
    private String nombre;
    private int edad;

    public Personas(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
