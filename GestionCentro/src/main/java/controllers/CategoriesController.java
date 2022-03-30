package controllers;

import models.Categories;
import repositories.ICategoryRepository;
/**
 * Controlador que gestionará las operaciones
 * que se harán sobre las categorías
 */
public class CategoriesController {

   private final ICategoryRepository categoryRepository;

   public CategoriesController(ICategoryRepository categoryRepository) {
      this.categoryRepository = categoryRepository;
   }








}
