package controllers;

import exceptions.CategoriesException;
import models.Categories;
import repositories.CategoryRepository;
import repositories.ICategoryRepository;

import java.util.List;
import java.util.Locale;

/**
 * Controlador que gestionará las operaciones
 * que se harán sobre las categorías
 */
public class CategoriesController {
      private static CategoriesController instance;
      private final ICategoryRepository categoryRepository;

    public CategoriesController(ICategoryRepository categoryRepository) {
      this.categoryRepository = categoryRepository;
   }

         /**
          * Metodo Singleton aplicado
          * @param categories Repositorio de Categorías
          * @return Una instancia de
          */
         public static CategoriesController getInstance(ICategoryRepository categories) {
            if (instance == null) {
                  instance = new CategoriesController(categories);
            }
            return instance;
         }


    /**
     * Añade una categoría con un nuevo nombre al sistema
      * @param category categoría a añadir
     * @return la categoría insertada
     * @throws CategoriesException excepcion que nos muestra un mensaje en caso de fallo
     */
    public Categories save(Categories category) throws CategoriesException{
         checkIsOk(category);
         var exists = categoryRepository.findByName(category.getName());

         if(exists == null){
             categoryRepository.save(category);
             return category;
         }else{
             throw new CategoriesException("Está categoría ya se encuentra dentro del sisitema ");
         }

    }

   /**
    * Procedimiento que averigua si el nombre a introducir está vacío o no
    * @param category categoría a observar
    * @throws CategoriesException lanza esta excepciono en caso de que el nombre esté vacío
    */
   public void checkIsOk(Categories category) throws CategoriesException {
         if(category.getName() == null || category.getName().trim().isEmpty()){
            throw new CategoriesException("No es posible introducir el nombre de esta categoría el espacio está vacío");

         }
      }

    /**
     * Función que nos devuelve una lista de categorías
     * @return
     */
   public List<Categories> getAllCategories(){
         return categoryRepository.findAll();
   }


    /**
     * Funcion que nos permite filtrar entre las categorias existentes por el nombre
     * @param categoryName Nombre de la categoría a insertar
     * @return la categoría buscada
     * @throws CategoriesException lanza esta excepcion en caso de que el nombre no se encuentre en la lista
     */
   public Categories getCategoryByName(String categoryName) throws CategoriesException{
      var categoryFound = categoryRepository.findByName(categoryName);
      if(categoryFound != null){
         return categoryFound;
      }
      throw new CategoriesException("No existe " + categoryName + " en la lista");
   }


    /**
     * Funcion que actualiza el nombre de la categoría
     * @param category categoría a actualizar
     * @return categoría actualizada
     * @throws CategoriesException lanza esta excepciono en caso de que no se pueda actualizar la categoría
     */
   public Categories updateCategory(Categories category) throws CategoriesException{
      checkIsOk(category);

      var categoryToBeUpdated = categoryRepository.findByName(category.getName());
      //Comprobamos si la categoría existe y si existe se actualizará sino lanza una excepción
      if((categoryToBeUpdated == null) || (categoryToBeUpdated.getName()==category.getName())){
          return categoryRepository.updated(category);
      }
       throw new CategoriesException("No se puede actualizar la categoría" + category);

   }










}
