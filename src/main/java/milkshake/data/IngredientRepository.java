package milkshake.data;

import org.springframework.data.repository.CrudRepository;

import milkshake.Ingredient;

public interface IngredientRepository 
	extends CrudRepository<Ingredient, String> {

	}



