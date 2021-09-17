package lambdacompare;

import java.util.Comparator;

public class ComparePersonas implements Comparator<Personas> {

    @Override
    public int compare(Personas o1, Personas o2) {
        return o1.getEdad() - o2.getEdad();
    }
}
