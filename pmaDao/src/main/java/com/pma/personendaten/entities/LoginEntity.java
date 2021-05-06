package com.pma.personendaten.entities;

import com.pma.Interfaces.entities.ILoginEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "login", schema = "pma")
public class LoginEntity extends AbstractPersistable<Long> implements ILoginEntity {

    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "loginTry")
    private int loginTry;

    @Column(name = "lastModified", nullable = false)
    private Date lastModified;


    @Column(name = "deletedTimeStamp", nullable = true)
    private Date deletedTimestamp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void increaseLoginTry() {
        if (!isLimitReached()) {
            loginTry++;
        }
    }

    @Override
    public void resetLoginTry() {
        loginTry = 0;
    }

    @Override
    public boolean isLimitReached() {
        return loginTry >= 3;
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

    @Override
    public Date getDeleteTimeStamp() {
        return deletedTimestamp;
    }

    @Override
    public Date getLastModifiedTimeStamp() {
        return lastModified;
    }

    @Override
    public Date setDeleteTimeStamp(Date deletedTimeStamp) {
        return this.deletedTimestamp = deletedTimeStamp;
    }

    @Override
    public Date setLastModifiedTimeStamp(Date lastModifiedTimeStamp) {
        return this.lastModified = lastModifiedTimeStamp;
    }

    public int getLoginTry() {
        return loginTry;
    }

    public void setLoginTry(int loginTry) {
        this.loginTry = loginTry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEntity that = (LoginEntity) o;

        if (loginTry != that.loginTry) return false;
        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + loginTry;
        return result;
    }
}
