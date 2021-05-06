package com.pma.person;

import com.pma.Interfaces.entities.IPersonenEntity;

import java.util.List;

public interface PersonService {

    IPersonenEntity getPerson();

    List<IPersonenEntity> getAllPerson();

    boolean changePerson();

    boolean deletePerson();

    boolean addPerson();


}
