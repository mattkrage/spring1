package sia.taco_cloud.tacos.data;

import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.tacos.TacoOrder;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    TacoOrder save(TacoOrder order);
}