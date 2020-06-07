package pl.dabrowski.zti.ZTI_Pesentation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dabrowski.zti.ZTI_Pesentation.model.LoginUser;
import pl.dabrowski.zti.ZTI_Pesentation.model.MyLoginUserDetails;
import pl.dabrowski.zti.ZTI_Pesentation.repositories.LoginUserRepository;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    LoginUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<LoginUser> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyLoginUserDetails::new).get();
    }
}
