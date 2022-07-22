package com.sain.Repository;

import com.sain.Model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {

    Optional<FileEntity> findByModuleIdAndModuleAndType(Integer moduleId, String module, String type);
    List<FileEntity> findByModuleIdAndModule(Integer moduleId, String module);
    List<FileEntity> findByModuleId(Integer moduleId);

}
