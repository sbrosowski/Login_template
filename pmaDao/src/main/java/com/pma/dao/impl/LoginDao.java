package com.pma.dao.impl;


import com.pma.Interfaces.entities.ILoginEntity;
import com.pma.dao.repositories.Dao;
import com.pma.personendaten.entities.LoginEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class LoginDao implements Dao<ILoginEntity> {

    private EntityManager entityManager;

    @Override
    public Optional<ILoginEntity> get(long id) {
        entityManager = getEntityManager();

        Optional<ILoginEntity> optional = Optional.ofNullable(entityManager.find(LoginEntity.class, id));

        entityManager.detach(optional);
        entityManager.close();

        return optional;
    }

    @Override
    public List<ILoginEntity> getAll() {
        entityManager = getEntityManager();
        String query = "Select l from LoginEntity l";
        TypedQuery<ILoginEntity> result = entityManager.createQuery(query, ILoginEntity.class);
        return result.getResultList();
    }

    @Override
    public void save(ILoginEntity loginEntity) {
        entityManager = getEntityManager();
        entityManager.merge(loginEntity);
        entityManager.close();
    }

    @Override
    public void update(ILoginEntity loginEntity, String[] params) {
        entityManager = getEntityManager();
    }

    @Override
    public void delete(ILoginEntity loginEntity) {
        entityManager = getEntityManager();
        entityManager.remove(loginEntity);
        entityManager.close();
    }
}
