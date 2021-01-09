package com.pma.dao.impl;

import com.pma.Interfaces.entities.ILoginEntity;
import com.pma.dao.repositories.Dao;

public class DaoFactory {
    private static DaoFactory _INSTANCE;

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        if (_INSTANCE == null) {
            _INSTANCE = new DaoFactory();
        }
        return _INSTANCE;
    }

    public Dao<ILoginEntity> getLoginDao() {
        Dao<ILoginEntity> dao = new LoginDao();
        return dao;
    }

}
