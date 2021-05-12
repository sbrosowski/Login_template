package com.pma;

import com.pma.Interfaces.entities.ILoginEntity;
import com.pma.persistence.model.entities.Login;
import com.pma.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        ArrayList<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
        authority.add(new SimpleGrantedAuthority("USER_ROLE"));

        Optional<ILoginEntity> userFound = userRepository.findByUsername(user);
        ILoginEntity dbUser = userFound.orElse(new Login());

        return new User(dbUser.getUsername(), dbUser.getPassword(), authority);
    }
}
