package com.pma.personendaten.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractPersistable<PK extends Serializable> {

    @Id
    @GeneratedValue
    private PK id;

    public AbstractPersistable() {
    }


    public PK getId() {
        return this.id;
    }

    protected void setId(PK id) {
        this.id = id;
    }

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(obj.getClass())) {
            return false;
        } else {
            AbstractPersistable<?> that = (AbstractPersistable) obj;
            return null != this.getId() && this.getId().equals(that.getId());
        }
    }

    public int hashCode() {
        int hashCode = 17;
        hashCode = hashCode + (null == this.getId() ? 0 : this.getId().hashCode() * 31);
        return hashCode;
    }
}
