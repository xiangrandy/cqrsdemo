package org.randy.adapter.persistence.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.randy.adapter.persistence.Persistantable;
import org.randy.domain.user.root.User;

@Entity
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@Table(name = "tb_user")
public class UserPO implements Persistantable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, length = 64)
    private String username;

    @Column(name = "pass", nullable = false, length = 64)
    private String password;

    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Column(name = "country", nullable = false, length = 64)
    private String country;

    @Column(name = "city", nullable = false, length = 64)
    private String city;

    @Column(name = "graduated", nullable = false)
    private boolean graduated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

}