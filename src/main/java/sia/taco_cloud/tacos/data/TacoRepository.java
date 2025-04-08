package sia.taco_cloud.tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sia.taco_cloud.tacos.Taco;
import sia.taco_cloud.tacos.User;

public interface TacoRepository  extends JpaRepository<Taco, Long> {
}
