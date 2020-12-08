package pma.dao.impl;


import pma.dao.interfaces.Dao;
import pma.personendaten.entities.LoginEntity;

import java.util.List;
import java.util.Optional;

public class LoginDao implements Dao<LoginEntity> {

    @Override
    public Optional<LoginEntity> get(long id) {
        return null;
    }

    @Override
    public List<LoginEntity> getAll() {
        return null;
    }

    @Override
    public void save(LoginEntity loginEntity) {

    }

    @Override
    public void update(LoginEntity loginEntity, String[] params) {

    }

    @Override
    public void delete(LoginEntity loginEntity) {

    }
}
