package com.sain.Repository;

import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity, Integer> {

    List<ResumeEntity> findByUserAssign(UserEntity userEntity);

}
