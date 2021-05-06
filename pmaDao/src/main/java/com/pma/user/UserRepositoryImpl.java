package com.pma.user;

import com.pma.Interfaces.entities.ILoginEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.Optional;

class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<ILoginEntity> findByUsername(String username) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ILoginEntity> query = criteriaBuilder.createQuery(ILoginEntity.class);

        Root<ILoginEntity> entity = query.from(ILoginEntity.class);
        query.select(entity);
        query.where(criteriaBuilder.equal(entity.get("username"), username));

        ILoginEntity loginEntity = em.createQuery(query).getSingleResult();

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
