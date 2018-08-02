package com.umssonline.proymgt.models.entity;

import javax.persistence.*;

@Entity
public class User {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nickName;
    @Column(nullable = false)
    private String role;
    //endregion

    //region Constructors
    protected User() {

    }

    public User(String nickName, String role) {
        this.nickName = nickName;
        this.role = role;
    }

    //endregion

    //region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //endregion
}
