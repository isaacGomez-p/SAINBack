package com.sain.Model;

public class ResumeAnswerDTO {

    private ResumeEntity resumeEntity;

    private AnswerEntity answerEntity;

    public AnswerEntity getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        this.answerEntity = answerEntity;
    }

    public ResumeEntity getResumeEntity() {
        return resumeEntity;
    }

    public void setResumeEntity(ResumeEntity resumeEntity) {
        this.resumeEntity = resumeEntity;
    }
}
