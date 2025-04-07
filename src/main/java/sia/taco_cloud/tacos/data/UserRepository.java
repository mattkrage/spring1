package sia.taco_cloud.tacos.data;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sia.taco_cloud.tacos.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);


}
