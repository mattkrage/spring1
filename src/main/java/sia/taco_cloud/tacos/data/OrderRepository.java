package sia.taco_cloud.tacos.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.tacos.TacoOrder;
import java.util.*;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

}