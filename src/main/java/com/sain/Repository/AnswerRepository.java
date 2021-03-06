package com.sain.Repository;

import com.sain.Model.AnswerEntity;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer> {

    List<AnswerEntity> findByResumes(ResumeEntity resumeEntity);

}
