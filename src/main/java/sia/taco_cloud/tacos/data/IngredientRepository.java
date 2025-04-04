package sia.taco_cloud.tacos.data;

import sia.taco_cloud.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
