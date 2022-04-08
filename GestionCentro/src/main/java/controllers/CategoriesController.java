package controllers;

import exceptions.CategoriesException;
import models.Categoria;
import repositories.categorias.ICategoryRepository;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador que gestionará las operaciones
 * que se harán sobre las categorías
 */
public class CategoriesController {
      private static CategoriesController instance;
      private final ICategoryRepository categoryRepository;

    public CategoriesController(ICategoryRepository categoryRepository) {
<<<<<<< HEAD
      this.categoryRepository = categoryRepository;

   }



         /**
          * Metodo Singleton aplicado
          * @param categories Repositorio de Categorías
          * @return Una instancia del controlador de categorías
          */
         public static CategoriesController getInstance(ICategoryRepository categories) {
            if (instance == null) {
                  instance = new CategoriesController(categories);
            }
            return instance;
         }
=======
        this.categoryRepository = categoryRepository;
    }

     /**
      * Método Singleton aplicado
      * @param categories Repositorio de Categorías
      * @return Una instancia de
      */
     public static CategoriesController getInstance(ICategoryRepository categories) {
        if (instance == null) {
              instance = new CategoriesController(categories);
        }
        return instance;
     }
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4


    /**
     * Añade una categoría con un nuevo nombre al sistema
     * @param category categoría a añadir
     * @return la categoría insertada
     * @throws CategoriesException excepcion que nos muestra un mensaje en caso de fallo
     */
<<<<<<< HEAD
    public Categories save(Categories category) throws CategoriesException, SQLException {
=======
    public Categoria save(Categoria category) throws CategoriesException{
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
         checkIsOk(category);
         var exists = categoryRepository.findByName(category.getName());

         if(exists.isEmpty()){
             categoryRepository.save(category);
             return category;
         }else{
             throw new CategoriesException("Está categoría ya se encuentra dentro del sistema");
         }

    }

   /**
    * Procedimiento que averigua si el nombre a introducir está vacío o no
    * @param category categoría a observar
    * @throws CategoriesException lanza esta excepciono en caso de que el nombre esté vacío
    */
   public void checkIsOk(Categoria category) throws CategoriesException {
         if(category.getName() == null || category.getName().trim().isEmpty()){
            throw new CategoriesException("No es posible introducir el nombre de esta categoría el espacio está vacío");

         }
   }

    /**
     * Función que nos devuelve una lista de categorías
     * @return Lista de Categorías
     */
<<<<<<< HEAD
   public List<Categories> getAllCategories() throws SQLException {
=======
   public List<Categoria> getAllCategories(){
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
         return categoryRepository.findAll();
   }


    /**
     * Funcion que nos permite filtrar entre las categorias existentes por el nombre
     * @param categoryName Nombre de la categoría a insertar
     * @return la categoría buscada
     * @throws CategoriesException lanza esta excepcion en caso de que el nombre no se encuentre en la lista
     */
<<<<<<< HEAD
   public Categories getCategoryByName(String categoryName) throws CategoriesException, SQLException {
       return categoryRepository.findByName(categoryName).orElseThrow(() -> new CategoriesException("No existe esta categoría en la lista"));
=======
   public Categoria getCategoryByName(String categoryName) throws CategoriesException {
       var categoryFound = categoryRepository.findByName(categoryName).orElseThrow(() -> new CategoriesException("No existe esta categoría en la lista"));
       return categoryFound;
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
   }


    /**
     * Funcion que actualiza el nombre de la categoría
     * @param category categoría a actualizar
     * @return categoría actualizada
     * @throws CategoriesException lanza esta excepciono en caso de que no se pueda actualizar la categoría
     */
<<<<<<< HEAD
   public Categories updateCategory(String s, Categories category) throws CategoriesException, SQLException {
=======
   public Categoria updateCategory( String s, Categoria category) throws CategoriesException{
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4
      checkIsOk(category);

      var categoryToBeUpdated = categoryRepository.findByName(category.getName());

      if(categoryToBeUpdated.isEmpty() || category.getName().equals(categoryToBeUpdated.get().getName())){
          categoryRepository.updated(s, category);
          return category;
      }

        throw new CategoriesException("No se puede actualizar una categoría inexistente");
   }

}
