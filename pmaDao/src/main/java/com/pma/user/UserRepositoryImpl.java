package com.pma.user;

import com.pma.Interfaces.entities.ILoginEntity;
import com.pma.persistence.model.entities.Login;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.Optional;

class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<ILoginEntity> findByUsername(String username) {
        Login loginEntity = null;
        try {

            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Login> criteriaQuery = criteriaBuilder.createQuery(Login.class);

            Root<Login> root = criteriaQuery.from(Login.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.like(root.get("username"), username));

            TypedQuery<Login> query = em.createQuery(criteriaQuery);
            loginEntity = query.getSingleResult();
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }


        return Optional.ofNullable(loginEntity);

    }

    @Override
    public void createUser(ILoginEntity user) {
        Optional<ILoginEntity> loginDataFromDB = findByUsername(user.getUsername());
        if (loginDataFromDB.isPresent()) {
            //Benutzer kann nicht angelegt werden
        } else {
            //Benutzer in DB einfügen
        }
    }

    @Override
    public void deleteUserByUsername(String username) {
        Optional<ILoginEntity> loginDataFromDB = findByUsername(username);
        if (loginDataFromDB.isPresent()) {
            ILoginEntity user = loginDataFromDB.get();
            user.setDeleteTimeStamp(new Date());
            user.setLastModifiedTimeStamp(new Date());
            em.merge(user);
        } else {
            //Benutzer kann nicht gelöscht werden
        }
    }

    @Override
    public void updateUser(ILoginEntity user) {
        Optional<ILoginEntity> loginData = findByUsername(user.getUsername());
        if (loginData.isPresent()) {
            user.setLastModifiedTimeStamp(new Date());
            em.merge(user);
        } else {
            //Update auf Benutzer nicht möglich
        }
    }
}
