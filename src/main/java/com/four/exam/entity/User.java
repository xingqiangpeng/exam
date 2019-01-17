package com.four.exam.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    private int uid;
    private String username;
    private String userpwd;
    private String usertel;
    private String usermessage;
    private String b1;
    private String b2;
    private String b3;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpwd")
    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Basic
    @Column(name = "usertel")
    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    @Basic
    @Column(name = "usermessage")
    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    @Basic
    @Column(name = "b1")
    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    @Basic
    @Column(name = "b2")
    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    @Basic
    @Column(name = "b3")
    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid &&
                Objects.equals(username, user.username) &&
                Objects.equals(userpwd, user.userpwd) &&
                Objects.equals(usertel, user.usertel) &&
                Objects.equals(usermessage, user.usermessage) &&
                Objects.equals(b1, user.b1) &&
                Objects.equals(b2, user.b2) &&
                Objects.equals(b3, user.b3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userpwd, usertel, usermessage, b1, b2, b3);
    }
}
