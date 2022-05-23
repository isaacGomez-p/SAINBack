package com.sain.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resume")
public class ResumeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="resume_id")
    private Integer resumeId;

    @Column(name="name" , length = 50)
    private String name;

    @Column(name="number_id" , length = 200, unique = true)
    private String numberId;

    @Column(name="verified")
    private Boolean verified;

    @Column(name="verification_date")
    private Date verificationDate;

    @ManyToOne
    @JoinColumn(name="user_id_by")
    private UserEntity userBy;

    @Column(name="recommendation" , length = 200)
    private String recommendation;

    @Column(name="observation" , length = 200)
    private String observation;

    @Column(name="process" , length = 20)
    private String process;

    @Column(name="score")
    private Integer score;

    @ManyToOne
    @JoinColumn(name="user_id_create")
    private UserEntity userCreate;

    @ManyToOne
    @JoinColumn(name="user_id_assign")
    private UserEntity userAssign;

    @Column(name="creation_date")
    private Date creationDate;

    @OneToMany(mappedBy="resumes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnswerEntity> answerEntities;

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public UserEntity getUserBy() {
        return userBy;
    }

    public void setUserBy(UserEntity userBy) {
        this.userBy = userBy;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public UserEntity getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(UserEntity userCreate) {
        this.userCreate = userCreate;
    }

    public UserEntity getUserAssign() {
        return userAssign;
    }

    public void setUserAssign(UserEntity userAssign) {
        this.userAssign = userAssign;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<AnswerEntity> getAnswerEntities() {
        return answerEntities;
    }

    public void setAnswerEntities(List<AnswerEntity> answerEntities) {
        this.answerEntities = answerEntities;
    }
}
