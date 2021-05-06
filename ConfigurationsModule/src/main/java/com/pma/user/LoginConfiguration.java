package com.pma.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class LoginConfiguration {

    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    @Profile({"default", "jdbc"})
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
}
