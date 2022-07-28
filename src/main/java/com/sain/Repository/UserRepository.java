package com.sain.Repository;

import com.sain.Model.RoleEntity;
import com.sain.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findByRoleEntity(RoleEntity role);
    Boolean existsByEmail(String email);
    Boolean existsByIdentification(String identification);

}
