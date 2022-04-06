package comparators;

import models.Categoria;

import java.util.Comparator;

public class CategoriesComparator  implements Comparator<Categoria> {

    /**
     * Método de comparar una categoría con otra existente.
     * @param o1 Primera Categoría
     * @param o2 Segunda Categoría
     * @return devuelve un número que será quien nos indique cuál es mayor.
     */


    @Override
    public int compare(Categoria o1, Categoria o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
