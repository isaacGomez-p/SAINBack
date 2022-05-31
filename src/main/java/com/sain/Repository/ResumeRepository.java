package com.sain.Repository;

import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity, Integer> {

    List<ResumeEntity> findByUserAssign(UserEntity userEntity);

    List<ResumeEntity> findByUserCreate(UserEntity userEntity);

    @Query("SELECT count(u) FROM ResumeEntity u WHERE u.recommendation = ?1")
    Long findByRecommendation(String recommendation);

}
