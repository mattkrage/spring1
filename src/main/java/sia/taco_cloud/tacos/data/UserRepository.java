package sia.taco_cloud.tacos.data;

import org.springframework.data.repository.CrudRepository;
import sia.taco_cloud.tacos.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
