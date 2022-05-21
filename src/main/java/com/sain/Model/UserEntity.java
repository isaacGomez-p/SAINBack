package com.sain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="name" , length = 60)
    private String name;

    @Column(name="lastname" , length = 60)
    private String lastname;

    @Column(name="role")
    private Integer role;

    @Column(name="identification" , length = 20, unique = true)
    private String identification;

    @Column(name="email", length = 120, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="password" , length = 100)
    private String password;

    @OneToMany(mappedBy="userMod",fetch = FetchType.LAZY)
    private List<AnswerEntity> answerEntities;

    @OneToMany(mappedBy="userAssign",fetch = FetchType.LAZY)
    private List<ResumeEntity> resumeEntities;

    @OneToMany(mappedBy="userCreate",fetch = FetchType.LAZY)
    private List<ResumeEntity> resumeEntities1;

    @OneToMany(mappedBy="userBy",fetch = FetchType.LAZY)
    private List<ResumeEntity> resumeEntities2;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AnswerEntity> getAnswerEntities() {
        return answerEntities;
    }

    public void setAnswerEntities(List<AnswerEntity> answerEntities) {
        this.answerEntities = answerEntities;
    }

    public List<ResumeEntity> getResumeEntities() {
        return resumeEntities;
    }

    public void setResumeEntities(List<ResumeEntity> resumeEntities) {
        this.resumeEntities = resumeEntities;
    }
}