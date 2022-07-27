package com.sain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"question_id", "resume_id"})
})
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Integer answerId;

    @Column(name="description" , length = 200)
    private String description;

    @Column(name="observation" , length = 200)
    private String observation;

    @Column(name="verified")
    private Boolean verified;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="verified_date")
    private Date verifiedDate;

    @Column(name="result")
    private Boolean result;

    @ManyToOne
    @JoinColumn(name="question_id")
    private QuestionsEntity questions;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private ResumeEntity resumes;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userMod;

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

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
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

    public QuestionsEntity getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionsEntity questions) {
        this.questions = questions;
    }

    @JsonIgnore
    @JsonProperty(value = "resume_id")
    public ResumeEntity getResumes() {
        return resumes;
    }

    public void setResumes(ResumeEntity resumes) {
        this.resumes = resumes;
    }

    public UserEntity getUserMod() {
        return userMod;
    }

    public void setUserMod(UserEntity userMod) {
        this.userMod = userMod;
    }
}
