package com.bigarson.todo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.bigarson.todo.base.BaseEntity;

@Entity
public class User extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String password;
    @Column
    private String eMail;
    @Column(columnDefinition = "boolean default false")
    private boolean emailStatus;
    @OneToMany(mappedBy = "user")
    private List<EventList> yapilacaklarListesi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isEmailStatus() {
        return emailStatus;
    }
    public void setEmailStatus(boolean emailStatus) {
        this.emailStatus = emailStatus;
    }
    public boolean getEmailStatus() {
        return emailStatus;
    }
}
