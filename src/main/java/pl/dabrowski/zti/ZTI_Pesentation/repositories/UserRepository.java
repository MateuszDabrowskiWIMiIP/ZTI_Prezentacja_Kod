package pl.dabrowski.zti.ZTI_Pesentation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dabrowski.zti.ZTI_Pesentation.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
