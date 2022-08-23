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
    private Integer verified;

    @Column(name="verification_date")
    private Date verificationDate;

    @Column(name="cost_center")
    private String costCenter;

    @Column(name="buss_unit")
    private String bussUnit;

    @Column(name="profile")
    private String profile;

    @ManyToOne
    @JoinColumn(name="user_id_by")
    private UserEntity userBy;

    @Column(name="recommendation" , length = 1)
    private String recommendation;

    @Column(name="status" , length = 200)
    private String status;

    @Column(name="prov_observation")
    private String provObservation;

    @Column(name="admin_observation")
    private String adminObservation;

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

    @Column(name="assign_date")
    private Date assignDate;

    @OneToMany(mappedBy="resumes", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
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

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getBussUnit() {
        return bussUnit;
    }

    public void setBussUnit(String bussUnit) {
        this.bussUnit = bussUnit;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getProvObservation() {
        return provObservation;
    }

    public void setProvObservation(String provObservation) {
        this.provObservation = provObservation;
    }

    public String getAdminObservation() {
        return adminObservation;
    }

    public void setAdminObservation(String adminObservation) {
        this.adminObservation = adminObservation;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
}
