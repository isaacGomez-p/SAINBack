package com.sain.Repository;

import com.sain.Model.RoleEntity;
import com.sain.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(Roles name);

}
