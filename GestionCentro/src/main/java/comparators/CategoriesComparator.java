package comparators;

import models.Categories;

import java.util.Comparator;

public class CategoriesComparator  implements Comparator<Categories> {

    /**
     * Método de comparar una categoría con otra existente.
     * @param o1 Primera Categoría
     * @param o2 Segunda Categoría
     * @return devuelve un número que será quien nos indique cuál es mayor.
     */


    @Override
    public int compare(Categories o1, Categories o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
