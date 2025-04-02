package sia.taco_cloud.tacos;

import java.util.List;
import lombok.Data;

@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;
}
