package com.sain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="question_id")
    private Integer questionId;

    @Column(name="description" , length = 200, unique = true)
    private String description;

    @Column(name="status", length = 1)
    private String status;

    @Column(name="priority")
    private Integer priority;

    @Column(name="height")
    private Integer height;

    @Column(name="section")
    private Integer section;

    @Column(name="type", length = 50)
    private String type;

    @OneToMany(mappedBy="questions",fetch = FetchType.LAZY)
    private List<AnswerEntity> answerEntities;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    @JsonIgnore
    @JsonProperty(value = "answerEntities")
    public List<AnswerEntity> getAnswerEntities() {
        return answerEntities;
    }

    public void setAnswerEntities(List<AnswerEntity> answerEntities) {
        this.answerEntities = answerEntities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
