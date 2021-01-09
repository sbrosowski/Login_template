package com.pma.user;

public interface UserRepository {

    void getById(long id);

    void listAll();

    void save();
}
