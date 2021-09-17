package ejercicio;

public class Examen implements Calificable {
    String name;
    Double nota;

    public Examen(String name, Double nota) {
        this.name = name;
        this.nota = nota;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public Double calificado() {
        return nota;
    }
}
