package com.sain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Integer answerId;

    @Column(name="description" , length = 200)
    private String description;

    @Column(name="verified")
    private Boolean verified;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name = "status", length = 1)
    private String status;

    //TODO proveedor de la verificacion
    //TODO fecha de la actualizacion

    @ManyToOne
    @JoinColumn(name="question_id")
    private QuestionsEntity questions;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    @JsonProperty(value = "question_id")
    public QuestionsEntity getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionsEntity questions) {
        this.questions = questions;
    }

    @JsonIgnore
    @JsonProperty(value = "user_id")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
