package com.pma.user;

import com.pma.Interfaces.entities.ILoginEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<ILoginEntity> findByUsername(String username);

    void createUser(ILoginEntity user);

    void deleteUserByUsername(String username);

    void updateUser(ILoginEntity user);


}
