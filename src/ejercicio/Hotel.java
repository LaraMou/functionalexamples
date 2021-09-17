package ejercicio;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel implements Calificable{
    String name;
    Integer estrellas;
    public Hotel(String name, Integer estrellas) {
        this.name = name;
        this.estrellas = estrellas;

    }

    @Override
    public Double calificado() {
        return Double.valueOf(estrellas);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }
}
