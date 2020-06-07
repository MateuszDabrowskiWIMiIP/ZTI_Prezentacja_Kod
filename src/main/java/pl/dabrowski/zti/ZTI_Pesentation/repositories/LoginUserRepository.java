package pl.dabrowski.zti.ZTI_Pesentation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dabrowski.zti.ZTI_Pesentation.model.LoginUser;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByUserName(String userName);
}