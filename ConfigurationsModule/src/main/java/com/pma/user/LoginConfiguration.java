package com.pma.user;

import com.pma.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
class LoginConfiguration extends DataSourceConfig {

    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    @Profile({"default", "jdbc"})
    UserRepository userRepository() {
        return new UserRepositoryJdbc();
    }
}
