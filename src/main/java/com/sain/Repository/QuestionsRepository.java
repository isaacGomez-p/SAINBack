package com.sain.Repository;

import com.sain.Model.QuestionsEntity;
import com.sain.Model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Integer> {

    List<QuestionsEntity> findByProfilesContainingAndRolesIn(String profile,Set<RoleEntity> roleEntitySet);
    List<QuestionsEntity> findByProfilesContaining(String profile);

}
